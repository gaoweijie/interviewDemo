package 算法.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树，返回它的 前序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树
public class 二叉树的前序遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的前序遍历().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;
        System.out.println("\n" + solution.preorderTraversal(node1));
    }



    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
//        public List<Integer> preorderTraversal(TreeNode node) {
//            if(node == null) return new ArrayList<>();
//
//            List<Integer> res = new ArrayList<>();
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(node);
//            while (!stack.isEmpty()) {
//                node = stack.pop();
//                res.add(node.val);
//                if (node.right != null) {
//                    stack.push(node.right);
//                }
//                if (node.left != null) {
//                    stack.push(node.left);
//                }
//            }
//            return res;
//        }
        List<Integer> res = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode node) {
            if (node == null) return new ArrayList<>();


            recur(node);
            return res;
        }

        private void recur(TreeNode node) {
            if (node == null) {
                return;
            }
            res.add(node.val);
            recur(node.left);
            recur(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}