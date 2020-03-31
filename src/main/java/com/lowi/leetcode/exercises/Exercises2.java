package com.lowi.leetcode.exercises;

/**
 * Exercises2.java
 *
 * @author : gengyy
 * @version : v2.0
 * @desc :
 * @since : 2020/3/25 11:05
 */
public class Exercises2 {

    public static void main(String[] args) {
//        int i = myAtoi("-");
//        System.out.println("i = " + i);
//
//        boolean palindrome1 = isPalindrome(101);
//        System.out.println("palindrome1 = " + palindrome1);

//        int[] a = new int[]{1, 2, 1};
//        int i1 = maxArea(a);
//        System.out.println("i1 = " + i1);

        String s = intToRoman(10000);
        System.out.println("s:" + s);

//        int mcmxciv = romanToInt("MCMXCIV");
//        System.out.println("mcmxciv = " + mcmxciv);
    }

    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * 说明：
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
     * 示例 1:
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−2^31) 。
     */
    public static int myAtoi(String str) {
        int a = 0;
        String trim = str.trim();
        if (trim.length() == 0) {
            return 0;
        }
        StringBuffer newNum = new StringBuffer();
        boolean upZero = false;
        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);
            if (i == 0) {
                if (c == '-') {
                    upZero = true;
                    continue;
                }
                if (c == '+') {
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    newNum.append(c);
                } else {
                    return 0;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    newNum.append(c);
                } else {
                    break;
                }
            }

        }
        if (newNum.length() == 0) {
            return 0;
        }
        try {
            a = upZero ? -Integer.parseInt(newNum.toString()) : Integer.parseInt(newNum.toString());
        } catch (Exception e) {
            if (upZero) {
                a = Integer.MIN_VALUE;
            } else {
                a = Integer.MAX_VALUE;
            }
        }
        return a;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出: true
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int b = 0;
        int a = x;
        while (a != 0) {
            int i = a % 10;
            a /= 10;
            b = b * 10 + i;
        }
        if (x == b) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * https://leetcode-cn.com/problems/regular-expression-matching/
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     */
    public static boolean isMatch(String s, String p) {
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/container-with-most-water/
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     */
    public static int maxArea(int[] height) {

        int maxarea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            maxarea = Math.max(maxarea, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxarea;
    }

    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * 输入: 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */
    public static String intToRoman(int num) {
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] number = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < number.length; i++) {
            while (num >= number[i]) {
                sb.append(roman[i]);
                num -= number[i];
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 罗马转数字
     * MCMXCIV
     */
    public static int romanToInt(String s) {
        int b = 0;
        int toInt = charToInt(s.charAt(0));
        int endInt = charToInt(s.charAt(s.length() - 1));
        for (int i = 1; i < s.length(); i++) {
            int newInt = charToInt(s.charAt(i));
            System.out.println("newInt = " + newInt);
            if (toInt >= newInt) {
                b += toInt;
            } else {
                b -= toInt;
            }
            System.out.println("b = " + b);
            toInt = newInt;
            System.out.println("toInt = " + toInt);
        }
        b += endInt;
        return b;
    }

    public static int charToInt(char a) {
        switch (a) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}
