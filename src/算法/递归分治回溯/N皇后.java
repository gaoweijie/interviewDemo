package 算法.递归分治回溯;

import java.util.*;

/**
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 */
public class N皇后 {

    public static void main(String[] args) {
        N皇后 test = new N皇后();
        List<List<String>> lists = test.solveNQueens(4);
        System.out.println(lists);
    }

    // 之前的皇后所能攻击的位置
    Set<Integer> cols = new HashSet<>();
    Set<Integer> pies = new HashSet<>();
    Set<Integer> nas = new HashSet<>();

    // 主函数入口
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<List<String>> result = new LinkedList<>();

        // init
        List<String> currentStatus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            currentStatus.add(init(n));
        }

        process(0, result, n, currentStatus);
        return result;
    }

    /**
     *
     * @param row        当前层
     * @param result    最终的结果
     * @param n         总层数
     * @param currentStatus
     */
    private void process(int row, List<List<String>> result, int n, List<String> currentStatus) {
        // 1. recursion terminator
        if (row == n) {
            // 千万别直接使用该对象，需要拷贝出一份来，防止result里的数据又被接下来的递归栈改变了。鄙人在此排查了很久才发现该隐晦的BUG
            // result.add(currentStatus);
            List<String> newCurrentStatus = copy(currentStatus, n);
            result.add(newCurrentStatus);
            return;
        }

        // 2. process logic in current level
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(col + row) || nas.contains(col - row)) { // go die
                continue;
            }
            // update the flag
            cols.add(col);
            pies.add(col + row);
            nas.add(col - row);

            String newLine = updateLine(n, col, currentStatus.get(row));
            currentStatus.set(row, newLine);

            // 3. drill down （调用函数去做子问题）
            process(row + 1, result, n, currentStatus);

            // 4. revert the current level status if needed
            cols.remove(col);
            pies.remove(col + row);
            nas.remove(col - row);

        }
    }

    private List<String> copy(List<String> currentStatus, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(currentStatus.get(i));
        }
        return ans;
    }

    public String init(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        return sb.toString();
    }

    public String updateLine(int n, int col, String line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }


}
