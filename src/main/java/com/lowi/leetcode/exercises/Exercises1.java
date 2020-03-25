package com.lowi.leetcode.exercises;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Exercises1.java
 * ==============================================
 * Copy right 2015-2017 by http://www.51lick.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : gengyy
 * @version : v2.0
 * @desc :
 * @since : 2020/3/20 15:23
 */
public class Exercises1 {
    public static void main(String[] args) {
//        int asdbjajsfjas = lengthOfLongestSubstring("asdbjacsfjas");

//        int[] num1 = new int[]{1, 3};
//        int[] num2 = new int[]{2};
//        double medianSortedArrays = findMedianSortedArrays(num1, num2);
//        System.out.println("medianSortedArrays = " + medianSortedArrays);

//        String asdbjacsfjas = longestPalindrome("asdbjacsfjas");
//        System.out.println("asdbjacsfjas = " + asdbjacsfjas);

        String s = "AB";
        int numRows = 1;
        String convert = converts(s, numRows);
        System.out.println("convert = " + convert);
    }


    //最大字符长度
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //判断set集合中是否出现此字符如果出现
            //放入set j++查询下一个字符
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                //Math.max 是一个三木源表达式
                ans = Math.max(ans, j - i);
            } else {
                //如果出现重复字符，则移除此字符之前所有字符，i++
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        double num = 0.0;
        if (list.size() % 2 == 0) {
            Integer a = list.get(list.size() / 2);
            Integer b = list.get((list.size() / 2) - 1);
            num = (double) (b + a) / 2;
        } else {
            int i = (list.size() - 1) / 2;
            num = list.get(i);
        }
        return num;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public static String longestPalindrome(String s) {
        String maxStr = null;

        return maxStr;
    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */
    public static String converts(String s, int numRows) {
        if (s.length() < numRows) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        int a = (s.length() > numRows ? numRows : s.length());
        for (int i = 0; i < a; i++) {
            rows.add(new StringBuffer());
        }
        int row = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
            System.out.println("row = " + row);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StringBuffer str : rows) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }


    public static String convert(String s, int numRows) {

        //如果只有1个直接返回
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        //判断传入行数是多少，行数和字符串长度做比较，行数>长度，则add几行
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

}
