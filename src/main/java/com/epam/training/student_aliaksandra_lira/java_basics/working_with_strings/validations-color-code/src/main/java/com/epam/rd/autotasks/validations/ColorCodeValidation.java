package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null) return false;
        Pattern patternColor = Pattern.compile("^#([A-Fa-f\\d]{6}|[A-Fa-f\\d]{3})$");
        Matcher matcherColor = patternColor.matcher(color);
        return matcherColor.matches();
    }
}





