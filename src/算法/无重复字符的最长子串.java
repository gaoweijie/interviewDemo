package 算法;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String str = "pwwkew";
        int maxLength = getMaxLength(str);
        System.out.println(maxLength);
    }

//    public static int getMaxLength(String str) {
//        char[] chars = str.toCharArray();
//
//        int maxLength = 0;
//        /** 找到出现第一个重复字符的位置 */
//        // i:字符串起始位置的滑动
//        for (int i = 0; i < chars.length; i++) {
//
//            int sameIndex = -1;
//            /**  判断子序列是否存在重复字符 */
//            // j:最长子序列位置的滑动
//            for (int j = i; j < chars.length; j++) {
//                int sameNum = 1;
//                for (int k = i; k < j; k++) {
//                    if (++sameNum == 2 && chars[k] == chars[j]) {
//                        sameIndex = j;
//                        // 跳出两层循环
//                        j = chars.length + 1;
//                        k = j + 1;
//                    }
//                }
//            }
//            int currentMax = sameIndex - i;
//            maxLength = Math.max(maxLength, currentMax);
//        }
//        return maxLength;
//    }

//    public static int getMaxLength(String str) {
//        char[] chars = str.toCharArray();
//
//        int maxLength = 0;
//        /** 找到出现第一个重复字符的位置 */
//        // i:字符串起始位置的滑动
//        for (int i = 0; i < chars.length; ) {
//            int sameRightIndex = -1;
//            int sameLeftIndex = -1;
//            /**  判断子序列是否存在重复字符 */
//            // j:最长子序列位置的滑动
//            for (int j = i; j < chars.length; j++) {
//                int sameNum = 1;
//                for (int k = i; k < j; k++) {
//                    if (++sameNum == 2 && chars[k] == chars[j]) {
//                        sameRightIndex = j;
//                        sameLeftIndex = k;
//
//                        // 跳出两层循环
//                        j = chars.length + 1;
//                        k = j + 1;
//                    }
//                }
//            }
//            int currentMax = sameRightIndex - i;
//            maxLength = Math.max(maxLength, currentMax);
//            if (sameLeftIndex != -1) {
//                i = sameLeftIndex + 1;
//            } else {
//                i++;
//            }
//        }
//        return maxLength;
//    }

    public static int getMaxLength(String str) {
        char[] chars = str.toCharArray();

        int maxLength = 0;
        /** 找到出现第一个重复字符的位置 */
        // i:字符串起始位置的滑动
        for (int i = 0; i < chars.length; ) {
            int currentMax = -1;
            int sameLeftIndex = -1;
            /**  判断子序列是否存在重复字符 */
//            // j:最长子序列位置的滑动
//            for (int j = i; j < chars.length; j++) {
//                int sameNum = 1;
//                for (int k = i; k < j; k++) {
//                    if (++sameNum == 2 && chars[k] == chars[j]) {
//                        sameRightIndex = j;
//                        sameLeftIndex = k;
//
//                        // 跳出两层循环
//                        j = chars.length + 1;
//                        k = j + 1;
//                    }
//                }
//            }
            Map map = new HashMap<>();
            for (int j = i; j < chars.length; j++) {
                if (map.containsKey(chars[j])) {
                    sameLeftIndex = (int) map.get(chars[j]);
                    currentMax = j - i;
                    break;
                } else {
                    map.put(chars[j], j);
                }
            }

            maxLength = Math.max(maxLength, currentMax);
            if (sameLeftIndex != -1) {
                i = sameLeftIndex + 1;
            } else {
                i++;
            }
        }
        return maxLength;
    }

    public static int solution(String s) {
        int res = 0;
        int i = 0;
        // key:字符串的值， value: 下标
        Map<Character, Integer> map = new HashMap<>();
//        for (int j = 0; j < s.length(); j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            res = Math.max(res, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j) + 1), i);
            }
            res = Math.max(res, j - i);
            map.put(s.charAt(j), j);
        }
        return res;
    }
}
