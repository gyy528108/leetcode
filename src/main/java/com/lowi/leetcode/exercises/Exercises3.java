package com.lowi.leetcode.exercises;


import java.util.ArrayList;
import java.util.List;

public class Exercises3 {

    public static void main(String[] args) {
        String[] a = new String[]{"flower", "flow", "flight"};
        String s = longestCommonPrefix(a);
        System.out.println("s = " + s);
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            int length = strs[i].length();
            minLength = Math.min(minLength, length);
        }
        List<Character> characters = new ArrayList<>();
        char a;
        boolean flag = false;
        for (int i = 0; i < minLength; i++) {
            a = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != a) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            characters.add(a);
        }
        StringBuffer sb = new StringBuffer();
        if (characters.size() > 0) {
            for (int i = 0; i < characters.size(); i++) {
                sb.append(characters.get(i));
            }
        } else {
            return "";
        }
        return sb.toString();
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 示例：
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            if (a + b + c == 0) {

            }
        }
        return null;
    }
}
