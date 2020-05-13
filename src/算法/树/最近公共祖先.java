package 算法.树;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class 最近公共祖先 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        lowestCommonAncestor(root, node5, node1);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p == q) {
            return p;
        }
        if ((root.left == p || root.right == p) && (root.left == q || root.right == q)) {
            return root;
        }
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        return findPath(root, p, q, map);
    }

    private static TreeNode findPath(TreeNode root, TreeNode p, TreeNode q, Map<TreeNode, TreeNode> map) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root.parent = null;
        int findNum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 找到了p/q节点
            if (node.val == p.val || node.val == q.val) {
                findNum++;
                if (findNum == 2) {
                    break;
                }
            }
            if (node.right != null) {
                node.right.parent = node;
                stack.push(node.right);
            }
            if (node.left != null) {
                node.left.parent = node;
                stack.push(node.left);
            }
        }
        // 从map中找到序列
        TreeNode temp1 = p;
        while (temp1 != null) {
            map.put(temp1, temp1.parent);
            temp1 = temp1.parent;
        }

        TreeNode temp2 = q;
        while (temp2 != null) {
            if (map.containsKey(temp2)) {
                return temp2;
            }
            temp2 = temp2.parent;
        }
        return null;
    }


    private static void find(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print("当前节点为：" + node + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

}

class TreeNode {
    int val; // 数据域
    TreeNode left;// 左子节点
    TreeNode right; // 右子节点
    TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }
}
