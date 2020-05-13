package 算法.递归分治回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {
        电话号码的字母组合 test = new 电话号码的字母组合();
        List<String> res = test.letterCombinations("23");
        System.out.println(res);
    }

    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<String>();
        search("", digits, 0, res);
        return res;
    }

    /**
     * @param s      每一轮生成的结果
     * @param digits 输入的参数
     * @param i      level
     * @param res    最终全部递归完成后生成的结果
     */
    private void search(String s, String digits, int i, List<String> res) {
        // 1. recursion terminator（子问题没有了/问题解决了，本质上是递归的层级到了最下面这个层级，也就是到了叶子结点）
        if (i == digits.length()) {
            res.add(s);
            return;
        }

        // 2. process(split your big problem) / prepare data （处理当前逻辑，就是把这个大问题如何分成子问题）
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            // 3. drill down（调用这个函数下探一层，解决更细节的子问题）
            search(s + letters.charAt(j), digits, i + 1, res);
        }

        // 4. revert the current level status if needed（此处不需要）
    }
}
