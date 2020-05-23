package 算法.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 *  
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 */
public class 复原IP地址 {

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("25525511135");
        System.out.println("\n\n\n" + strings);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        recur(s,0,  new ArrayList<>(), result);
        return result;
    }

    /**
     *
     * @param originStr     原始字符串
     * @param currentIndex  指针位置
     * @param temp          生成的有效的字符串
     * @param result        最终的结果
     */
    private static void recur(String originStr, int currentIndex, ArrayList<String> temp, List<String> result) {
        // 1.terminate
        if (temp.size() == 4) {
            if (currentIndex == originStr.length()) {
//                result.add(convertToString(temp));
                result.add(String.join(".",temp));
            }
            return;
        }

        // 2.process current logic
        for (int i = 1; i <= 3; i++) {
            if (currentIndex + i > originStr.length()) {
                break;
            }
            String substring = originStr.substring(currentIndex, currentIndex + i);
            int newIndex = currentIndex + i;
            if (Integer.valueOf(substring) <= 255 && temp.size() < 4 && !(substring.startsWith("0") && substring.length()>1)) {
                temp.add(substring);
                // 3.drill down
                recur(originStr, newIndex, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static String convertToString(ArrayList<String> temp) {
        StringBuilder sb = new StringBuilder();
        for (String item : temp) {
            sb.append(item).append(".");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

}
