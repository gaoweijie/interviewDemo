package 算法.字符串;

/**
 * 翻转字符串里的单词2
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例：
 * 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 注意：
 * <p>
 * 单词的定义是不包含空格的一系列字符
 * 输入字符串中不会包含前置或尾随的空格
 * 单词与单词之间永远是以单个空格隔开的
 * 进阶：使用 O(1) 额外空间复杂度的原地解法。
 */
public class 翻转字符串里的单词2 {
    public static void main(String[] args) {
        char[] s = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};

        solution(s);

    }

    public static void solution(char[] s) {
        System.out.print("[");
        String str = String.valueOf(s);
        String[] split = str.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            for (int j = 0; j < split[i].length(); j++) {
                if (i == 0 && j == split[i].length() - 1) {
                    System.out.print("'" + split[i].charAt(j) + "'");
                } else {
                    System.out.print("'" + split[i].charAt(j) + "'" + ",");
                }
            }
            if (i > 0) {
                System.out.print("' ',");
            }
        }
        System.out.println("]");
    }

}
