package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null) return false;
        Pattern patternEmail = Pattern.compile("^[a-z]+_[a-z]+\\d*@epam\\.com$");
        Matcher matcherEmail = patternEmail.matcher(email);
        return matcherEmail.matches();

    }
}





