package 算法.字符串;

/**
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出:
 * <p>
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class 字符串的排列 {

    public static void main(String[] args) {
        字符串的排列 test = new 字符串的排列();
        System.out.println(test.checkInclusion("ab", "eidbaooo") == true);
        System.out.println(test.checkInclusion("ab", "eidboaoo") == false);
        System.out.println(test.checkInclusion("ab", "ab") == true);
        System.out.println(test.checkInclusion("hello", "ooolleoooleh") == false);
        System.out.println(test.checkInclusion("adc", "dcda") == true);
    }


//    public boolean checkInclusion(String s1, String s2) {
//        // init s1 mapS1
//        Map<Character, Integer> mapS1 = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            if (mapS1.containsKey(s1.charAt(i))) {
//                mapS1.put(s1.charAt(i), mapS1.get(s1.charAt(i)) + 1);
//            } else {
//                mapS1.put(s1.charAt(i), 1);
//            }
//        }
//
//
//        int length = s1.length();
//        for (int i = 0; i <= s2.length() - length; ) {
//            String substring = s2.substring(i, i + length);
//            int index = isSame(s1, substring, mapS1);
//            System.out.println("下标=" + index);
//            if (index == -1) {
//                return true;
//            } else {
//                i = i + index + 1;
//            }
//        }
//        return false;
//    }

//    public boolean checkInclusion(String s1, String s2) {
//        // init s1 mapS1
//        Map<Character, Integer> mapS1 = new HashMap<>();
//        Map<Character, Integer> originMapS1 = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            if (mapS1.containsKey(s1.charAt(i))) {
//                mapS1.put(s1.charAt(i), mapS1.get(s1.charAt(i)) + 1);
//                originMapS1.put(s1.charAt(i), originMapS1.get(s1.charAt(i)) + 1);
//            } else {
//                mapS1.put(s1.charAt(i), 1);
//                originMapS1.put(s1.charAt(i), 1);
//            }
//        }
//
//        for (int i = 0; i < s2.length(); i++) {
//            char currentChar = s2.charAt(i);
//            if (!mapS1.containsKey(currentChar)) {
//                mapS1.clear();
//                for (Character key : originMapS1.keySet()) {
//                    mapS1.put(key, originMapS1.get(key));
//                }
//            } else {
//                Integer newNum = mapS1.get(currentChar) - 1;
//                if (newNum == 0) {
//                    mapS1.remove(currentChar);
//                } else {
//                    mapS1.put(currentChar, newNum);
//                }
//            }
//            if (mapS1.isEmpty()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 一致返回-1，否则不同字符时的返回下标
//     */
//    public int isSame(String s1, String s2, Map<Character, Integer> mapS1) {
//        for (int i = 0; i < s2.length(); i++) {
//            char currentChar = s2.charAt(i);
//            int num = 0;
//            for (int j = 0; j < s2.length(); j++) {
//                if (s2.charAt(j) == currentChar) {
//                    num++;
//                }
//            }
//
//            if (!mapS1.containsKey(currentChar) || mapS1.get(currentChar) != num) {
//                return i;
//            }
//        }
//        return -1;
//    }

//    public boolean checkInclusion(String s1, String s2) {
//        // init s1 mapS1
//        Map<Character, Integer> mapS1 = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            if (mapS1.containsKey(s1.charAt(i))) {
//                mapS1.put(s1.charAt(i), mapS1.get(s1.charAt(i)) + 1);
//            } else {
//                mapS1.put(s1.charAt(i), 1);
//            }
//        }
//
//        int length = s1.length();
//        for (int i = 0; i <= s2.length() - length; ) {
//            String substring = s2.substring(i, i + length);
//            int index = isSame(mapS1, substring);
//            System.out.println("下标=" + index);
//            if (index == -1) {
//                return true;
//            } else {
//                i = i + index + 1;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 一致返回-1，否则不同字符时的返回下标
//     */
//    public int isSame(Map<Character, Integer> mapS1, String s2) {
//        for (int i = 0; i < s2.length(); i++) {
//            char c = s2.charAt(i);
//            if (!mapS1.containsKey(c)) {
//                return i;
//            } else {
//                Integer newNum = mapS1.get(c) - 1;
//                if (newNum == 0) {
//                    mapS1.remove(c);
//                } else {
//                    mapS1.put(c, newNum);
//                }
//            }
//        }
//        return -1;
//    }

    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        if (s2.length() < length) {
            return false;
        }

        // init
        int[] recordS1 = new int[26];
        int[] recordS2 = new int[26];
        for (int i = 0; i < length; i++) {
            int indexS1 = s1.charAt(i) - 'a';
            recordS1[indexS1]++;
            int indexS2 = s2.charAt(i) - 'a';
            recordS2[indexS2]++;
        }
        // check
        if (isSame(recordS1, recordS2)) {
            return true;
        }

        // 逐步滑动
        for (int i = length; i < s2.length(); i++) {
            int deleteIndex = s2.charAt(i - length) - 'a';
            recordS2[deleteIndex]--;
            recordS2[s2.charAt(i) - 'a']++;
            // check
            if (isSame(recordS1, recordS2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSame(int[] recordS1, int[] recordS2) {
        for (int j = 0; j < recordS2.length; j++) {
            if (recordS2[j] != recordS1[j]) {
                return false;
            }
        }
        return true;
    }

}
