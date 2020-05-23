package 算法.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划
public class 三角形最小路径和 {
    public static void main(String[] args) {
        Solution solution = new 三角形最小路径和().new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(triangle));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int row;
        Integer[][] memo;

        public int minimumTotal(List<List<Integer>> triangle) {
            row = triangle.size();
            memo = new Integer[row][row];
            return helper(0, 0, triangle);
        }

        private int helper(int level, int c, List<List<Integer>> triangle) {
            // System.out.println("helper: level="+ level+ " c=" + c);
            if (memo[level][c] != null) {
//                System.out.print(memo[level][c] + " ");
                return memo[level][c];
            }
            if (level == row - 1) {
//                System.out.println("\n222222222");
                return memo[level][c] = triangle.get(level).get(c);
            }

            int left = helper(level + 1, c, triangle);
            int right = helper(level + 1, c + 1, triangle);
            return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}