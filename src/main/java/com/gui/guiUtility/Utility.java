package com.gui.guiUtility;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    /**
     * @param daysToAdd
     * @return
     */
    public String getFutureDate(long daysToAdd) {
        LocalDate locale = LocalDate.now().plusDays(daysToAdd);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return locale.format(dateTimeFormatter);
    }

    /**
     * @param name
     * @return
     */
    public boolean isValidUsername(String name) {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }

    /**
     * @param count
     * @return
     */
    public String randomSpecial(int count)
    {
        String characters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String generatedString = RandomStringUtils.random(count, characters);
        return generatedString;
    }
}
