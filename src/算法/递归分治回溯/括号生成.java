package 算法.递归分治回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
public class 括号生成 {

    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        括号生成 test = new 括号生成();
        List<String> a = test.generateParenthesis(3);
        System.out.println(a);
    }

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "", result);
        return result;
    }

    /**
     * 判断条件：
     *      左括号可以放：左括号数量还有
     *      右括号可以放：左括号数量多于右括号数量，右括号还有（右括号还有必然满足）
     * @param leftNum
     * @param rightNum
     * @param max 括号对数
     * @param s
     * @param totalList
     */
    private void generate(int leftNum, int rightNum, int max, String s, List<String> totalList) {
        if (leftNum == max && rightNum == max) {
            totalList.add(s);
            return;
        }
        if (leftNum < max) {
            generate(leftNum + 1, rightNum, max, s + "(", totalList);
        }
        if (leftNum > rightNum) {
            generate(leftNum, rightNum + 1, max, s + ")", totalList);
        }
    }
}
