package 算法.递归分治回溯;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 */
public class 验证二叉搜索树 {

    long lastVal = Long.MIN_VALUE;

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
//        return core(root, null, null);
        return dfs(root);
    }

    /**
     * 方案1：使用TreeNode本身做上下界【Perfect！】
     */
    private boolean core(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) return true;
        if(min != null && node.val <= min.val) return false;
        if(max != null && node.val >= max.val) return false;
        return core(node.left, min, node) && core(node.right, node, max);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        search(node.left);
        System.out.println(node);
        search(node.right);
    }


    /**
     * 方案二：结合中序遍历
     */
    boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean leftResult = dfs(node.left);
        if (!leftResult)
            return false;

        // 每次中序出来的新的值肯定要大于之前存的值才行
        if (node.val <= lastVal)
            return false;
        lastVal = node.val;

        boolean rightResult = dfs(node.right);
        if (!rightResult)
            return false;

        return true;
    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
