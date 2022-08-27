package com.epam.rd.autotasks.words;

import java.util.Arrays;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null || words.length == 0) return 0;
        int count = 0;
        for (String word : words) {
            if (word.strip().equalsIgnoreCase(sample.strip())) count++;
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isBlank() || text.matches("\\W+")) return null;
        text = text.replaceFirst("^\\W+", "");
        text = text.strip();
        return text.split("\\W+");
    }

    public static String convertPath(String path, boolean toWin) {
        // Preconditions
        if (path == null || path.isBlank() || path.isEmpty()) return null;
        if (path.contains("//") || path.contains("\\\\")) return null;
        if (path.contains("/") && path.contains("\\")) return null;
        if (path.contains("~") && path.contains("\\")) return null;
        if (path.contains("~") && !path.startsWith("~")) return null;
        if (path.matches(".*~.*~.*")) return null;
        if (path.matches(".*C:.*C:.*")) return null;

        // Replace operations
        if (toWin && path.contains("~")) path = path.replace("~", "C:\\User");
        if (!toWin && path.contains("C:\\User")) path = path.replace("C:\\User", "~");
        if (toWin && path.contains("/")) path = path.replace("/", "\\");
        if (!toWin && path.contains("\\")) path = path.replace("\\", "/");
        if (path.contains("..")) return path;
        if (toWin && !path.startsWith("\\")) return path;
        if (!toWin && path.contains("C:")) return path.replace("C:", "");
        if (toWin && !path.contains("C:")) return "C:" + path;
        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) return null;
        StringBuilder joinWords = new StringBuilder("[");
        int emptyWordsCounter = 0;
        for (String word : words) {
            if (!word.isBlank()) joinWords.append(word).append(", ");
            else emptyWordsCounter++;
        }
        if (emptyWordsCounter == words.length) return null;
        joinWords.delete(joinWords.length() - 2, joinWords.length()).append("]");
        return joinWords.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}