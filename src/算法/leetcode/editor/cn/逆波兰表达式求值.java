package 算法.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//根据逆波兰表示法，求表达式的值。
//
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 示例 1： 
//
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: ((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: (4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
// Related Topics 栈
public class 逆波兰表达式求值 {
    public static void main(String[] args) {
        Solution solution = new 逆波兰表达式求值().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            List<String> calList = new ArrayList<>();
            calList.add("+");
            calList.add("-");
            calList.add("*");
            calList.add("/");

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                if (!calList.contains(tokens[i])) {
                    stack.add(Integer.valueOf(tokens[i]));
                } else {
                    // 给定逆波兰表达式总是有效的，故不考虑符号在最前面的情况
                    int b = stack.pop();
                    int a = stack.pop();
                    if ("+".equals(tokens[i])) {
                        int c =  a + b;
                        stack.push(c);
                    } else if ("-".equals(tokens[i])) {
                        int c =  a - b;
                        stack.push(c);
                    } else if ("*".equals(tokens[i])) {
                        int c =  a * b;
                        stack.push(c);
                    } else if ("/".equals(tokens[i])) {
                        int c =  a / b;
                        stack.push(c);
                    }
                }
            }
            return stack.pop();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}