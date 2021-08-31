package com.imdsc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringUtil {

    /**
     * e.g.
     * ["123","456"] = function("123456",3)
     * <p>
     * substring by length
     *
     * @param str    string that waiting for split
     * @param length the length of split
     * @return {@link List<String>} string list
     */
    public static List<String> substringByLength(String str, int length) {
        CheckUtil.notNull("str", str);
        List<String> list = new ArrayList<>();
        while (str.length() >= length) {
            String sub = str.substring(0, length);
            list.add(sub);
            str = str.substring(length);
        }
        return list;
    }

    /**
     * verify a string is null or empty
     *
     * @param str the string to be valid
     * @return while str is null or str is empty string return ture; other situation return false
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * reverse string
     *
     * @param str the string waiting for reverse
     * @return reversed string
     */
    public static String reverse(String str) {
        CheckUtil.notNull("str", str);
        char[] chars = str.toCharArray();
        int lastIndex = str.length() - 1;
        StringBuilder reversedString = new StringBuilder();
        for (int i = lastIndex; i >= 0; i--) {
            reversedString.append(chars[i]);
        }
        return reversedString.toString();
    }
}
