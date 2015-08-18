package com.kongming.util;

/**
 * 说明:
 * User: kongming
 * Date: 2015/5/7
 * Time: 18:15
 */
public class Common {

    public static String lpad(String str, int length, char pad) {
        return String.format("%1$#" + length + "s", str).replace(' ', pad);
    }
}
