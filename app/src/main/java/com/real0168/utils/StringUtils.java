package com.real0168.utils;

import java.util.regex.Pattern;

public class StringUtils {

    public static boolean isPhoneNumber(String phoneNumber){
        return isMatch("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,1,3,5-8])|(18[0-9])|(147))\\d{8}$", phoneNumber);
    }

    public static boolean isEmail(String email){
        return isMatch("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", email);
    }

    public static boolean isIDCarNumber(String carNumber){
        return isMatch("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$", carNumber);
    }
    private static boolean isMatch(String regex,CharSequence input) {
        return input !=null&& input.length() >0&& Pattern.matches(regex,input);
    }
}
