package com.imdsc.util;

import java.util.SplittableRandom;

/**
 * Random Util
 * @author Zhuang Wei Yi
 * @since 1.0.0.RELEASE
 */
public class RandomUtil {

    public static final int[] UPPER_CASE_ASCII = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
            82, 83, 84, 85, 86, 87, 88, 89, 90};
    public static final int[] LOWER_CASE_ASCII = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final int[] NUMBER_ASCII = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};

    public static final int[][] TYPE_ARR = {UPPER_CASE_ASCII, LOWER_CASE_ASCII, NUMBER_ASCII};

    /**
     * generate random string
     * @param length the length of random string
     * @return random string
     * @throws IllegalArgumentException length must be positive
     * @since 1.0.0.RELEASE
     */
    public static String generateRandomStrings(int length) throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException("length must be positive");
        }

        String randomStrings = "";

        for (int i = 0; i < length; i++) {
            SplittableRandom random = new SplittableRandom();
            // some type
            int type = random.nextInt(0, TYPE_ARR.length);
            int[] asciiArr = TYPE_ARR[type];

            // some char
            int arrLength = asciiArr.length;
            int arrIndex = random.nextInt(0, arrLength);
            char c = (char) asciiArr[arrIndex];

            randomStrings = randomStrings.concat(String.valueOf(c));
        }

        return randomStrings;
    }
}
