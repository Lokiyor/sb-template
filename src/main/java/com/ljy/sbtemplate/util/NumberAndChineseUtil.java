package com.ljy.sbtemplate.util;

import java.util.Stack;

import static com.ljy.sbtemplate.util.NumberAndChineseUtil.ChineseUnit.*;

/**
 * @author Lokiy
 * @date 2018/8/13
 * @description 阿拉伯数字转中文
 */
public class NumberAndChineseUtil {

    private static final String[] CHINESE_NUMBERS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    private static final ChineseUnit[] CHINESE_UNIT = {zero, ten, hundred, thousand, ten_thousand, billion, million, ten_million, hundred_mullion};

    private static final String[] CHINESE_NUMBERS_2 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    private static final int SHI = 10;

    /**
     *  阿拉伯数字转中文
     * @param number
     * @return
     */
    public static String translateNumber2Chinese(int number) {
        String s = String.valueOf(number);
        if (number <= SHI) {
            return CHINESE_NUMBERS[number];
        }
        Stack<NumberUnit> stack = new Stack<>();
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            NumberUnit numberUnit = new NumberUnit();
            numberUnit.chineseNumber = CHINESE_NUMBERS_2[Integer.parseInt(String.valueOf(s.charAt(i)))];
            numberUnit.chineseUnit = CHINESE_UNIT[index];
            numberUnit.originalNumber = Integer.parseInt(String.valueOf(s.charAt(i)));
            stack.push(numberUnit);
            index ++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            NumberUnit numberUnit = stack.pop();
            if (numberUnit.originalNumber > 0) {
                stringBuilder.append(numberUnit.chineseNumber);
                if (numberUnit.chineseUnit != zero) {
                    stringBuilder.append(numberUnit.chineseUnit.getValue());
                }
            } else if (numberUnit.chineseUnit != zero) {
                NumberUnit nextNumber = stack.peek();
                if (nextNumber != null && nextNumber.originalNumber != 0) {
                    stringBuilder.append(numberUnit.chineseNumber);
                }
            }
        }
        return stringBuilder.toString();
    }

    private static class NumberUnit {

        ChineseUnit chineseUnit;

        String chineseNumber;

        int originalNumber;
    }

    enum ChineseUnit {
        /**
         *
         */
        zero("零"),
        /**
         *
         */
        ten("十"),
        /**
         *
         */
        hundred("百"),
        thousand("千"),
        ten_thousand("万"),
        billion("十"),
        million("百"),
        ten_million("千"),
        hundred_mullion("亿")
        ;

        private String value;

        ChineseUnit(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println(translateNumber2Chinese(1));
    }
}
