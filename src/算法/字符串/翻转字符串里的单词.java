package 算法.字符串;

/** 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例2：
 * 输入: "  hello world!  "
 * 输出: "world! hello" 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例3：
 * 输入: "a good   example"
 * 输出: "example good a"
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        翻转字符串里的单词 test = new 翻转字符串里的单词();

        String a1 = "the sky is blue";
        String s1 = test.reverseWords(a1);
        System.out.println(s1);

        String a2 = "  hello world!  ";
        String s2 = test.reverseWords(a2);
        System.out.println(s2);

        String a3 = "a good   example";
        String s3 = test.reverseWords(a3);
        System.out.println(s3);
    }

    public String reverseWords(String s) {

        StringBuffer sb = new StringBuffer();
        String[] split = s.split(" ");
        for (int i = split.length - 1; i >=0; i--) {
            String str = split[i];
            if (str.trim().length() == 0) {
                continue;
            }
            sb.append(str).append(" ");
        }

        if (sb.length() > 0 && sb.lastIndexOf(" ")  == sb.toString().length() - 1) {
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }
}
