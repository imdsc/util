package com.imdsc.util;

import java.util.SplittableRandom;

/**
 * 随机工具类
 * @author Zhuang Wei Yi
 * @since 2020/11/04 13:58
 * @since 1.0-SNAPSHOT
 */
public class RandomUtil {

    public static final int[] UPPER_CASE_ASCII = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
            82, 83, 84, 85, 86, 87, 88, 89, 90};
    public static final int[] LOWER_CASE_ASCII = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final int[] NUMBER_ASCII = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};

    public static final int[][] TYPE_ARR = {UPPER_CASE_ASCII, LOWER_CASE_ASCII, NUMBER_ASCII};

    /**
     * 生成指定长度的随机字符串
     * @param length 随机字符串的长度
     * @return 随机字符串
     * @throws IllegalArgumentException length必须是正整数
     * @since 1.0-SNAPSHOT
     */
    public static String generateRandomStrings(int length) throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException("length 必须是正整数");
        }

        String randomStrings = "";

        for (int i = 0; i < length; i++) {
            SplittableRandom random = new SplittableRandom();
            // 某一个类型
            int type = random.nextInt(0, TYPE_ARR.length);
            int[] asciiArr = TYPE_ARR[type];

            // 某一个字符
            int arrLength = asciiArr.length;
            int arrIndex = random.nextInt(0, arrLength);
            char c = (char) asciiArr[arrIndex];

            randomStrings = randomStrings.concat(String.valueOf(c));
        }

        return randomStrings;
    }
}
