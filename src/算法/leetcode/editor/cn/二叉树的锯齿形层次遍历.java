package 算法.leetcode.editor.cn;

import java.util.*;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索
public class 二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        Solution solution = new 二叉树的锯齿形层次遍历().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        TreeNode node3 = new TreeNode(3);
        node1.right = node3;
        node2.left = new TreeNode(4);
        node2.right = new TreeNode(5);
        node3.right = new TreeNode(6);

        List<List<Integer>> lists = solution.zigzagLevelOrder(node1);
        System.out.println(lists);
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
        public List<List<Integer>> zigzagLevelOrder1(TreeNode node) {
            if (node == null) return new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            boolean asc = false;

            while (!queue.isEmpty()) {
                List<Integer> item = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    node = queue.poll();
                    item.add(node.val);
                    if (!asc) {
                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                        if (node.left != null) {
                            queue.offer(node.left);
                        }
                    } else {
                        if (node.left != null) {
                            queue.offer(node.left);
                        }
                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    }
                }
                asc = !asc;
                res.add(item);
            }
            return res;
        }

        public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
            if (node == null) return new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(node);
            boolean asc = false;
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                List<Integer> item = new ArrayList<>();
                if (!asc) {
                    while (!stack1.isEmpty()) {
                        node = stack1.pop();
                        System.out.print("stack1->" + node.val + " ");
                        item.add(node.val);
                        if (node.left != null) stack2.push(node.left);
                        if (node.right != null) stack2.push(node.right);
                    }
                } else {
                    while (!stack2.isEmpty()) {
                        node = stack2.pop();
                        System.out.print("stack2->" + node.val + " ");
                        item.add(node.val);
                        if (node.right != null) stack1.push(node.right);
                        if (node.left != null) stack1.push(node.left);
                    }
                }
                asc  = !asc;
                res.add(item);
            }
            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}