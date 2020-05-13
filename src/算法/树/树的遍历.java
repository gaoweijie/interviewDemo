package 算法.树;

import java.util.*;

public class 树的遍历 {

    private static class BinaryTreeNode {
        int data; // 数据域
        BinaryTreeNode left;// 左子节点
        BinaryTreeNode right; // 右子节点

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    private static class TreeNode {
        String data; // 数据域
        List<TreeNode> childNodes = new ArrayList<>();// 左子节点

        public TreeNode(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(4);
        root.left.left.left = new BinaryTreeNode(8);
        root.left.left.right = new BinaryTreeNode(9);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(10);
        root.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        System.out.println("先序遍历的递归和非递归对比：");
        noRecursionPreOrder(root);
        System.out.println();
        recursionPreOrder(root);
        System.out.println();

        System.out.println("中序遍历的递归和非递归对比：");
        noRecursionMidOrder(root);
        System.out.println();
        recursionMidOrder(root);
        System.out.println();

        System.out.println("后序遍历的递归和非递归对比：");
        noRecursionPostOrder(root);
        System.out.println();
        recursionPostOrder(root);
        System.out.println();


        TreeNode a2 = new TreeNode("A");
        TreeNode b2 = new TreeNode("B");
        TreeNode c2 = new TreeNode("C");
        TreeNode d2 = new TreeNode("D");
        TreeNode e2 = new TreeNode("E");
        TreeNode f2 = new TreeNode("F");
        a2.childNodes.add(b2);
        a2.childNodes.add(e2);
        b2.childNodes.add(c2);
        b2.childNodes.add(d2);
        e2.childNodes.add(f2);

        System.out.println("多叉树的深度遍历的递归和非递归对比：");
        noRecursionDfs(a2);
        System.out.println();
        recursionDfs(a2);
        System.out.println();

        System.out.println("多叉树的广度遍历的递归和非递归对比：");
        List<TreeNode> list = new ArrayList<>();
        list.add(a2);
        noRecursionBfs(list, 0);
        System.out.println();
        recursionBfs(a2);
        System.out.println();

    }

    // 递归版 --> 二叉树(先序遍历)
    public static void noRecursionPreOrder(BinaryTreeNode node) {
        // 1. 递归终止条件
        if (node == null) return;
        // 2. 处理当前层逻辑
        System.out.print(node.data + " ");
        // 3. 下挖一层
        noRecursionPreOrder(node.left);
        noRecursionPreOrder(node.right);
    }

    // 非递归版 --> 二叉树(先序遍历)
    public static void recursionPreOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 递归版 --> 二叉树(中序遍历)
    public static void noRecursionMidOrder(BinaryTreeNode node) {
        if (node == null) return;
        noRecursionMidOrder(node.left);
        System.out.print(node.data + " ");
        noRecursionMidOrder(node.right);
    }

    // 非递归版 --> 二叉树(中序遍历)
    public static void recursionMidOrder(BinaryTreeNode node) {
        if (node == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    // 递归版 --> 二叉树(后序遍历)
    public static void noRecursionPostOrder(BinaryTreeNode node) {
        if (node == null) return;
        noRecursionPostOrder(node.left);
        noRecursionPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    // 非递归版 --> 二叉树(后序遍历)
    public static void recursionPostOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    // 递归版 --> 深度遍历
    public static void recursionDfs(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        for (int i = 0; i < node.childNodes.size(); i++) {
            recursionDfs(node.childNodes.get(i));
        }
    }

    // 非递归版 --> 深度遍历
    public static void noRecursionDfs(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.data + " ");
            for (int i = node.childNodes.size() - 1; i >= 0; i--) {
                stack.push(node.childNodes.get(i));
            }
        }
    }

    // 递归版 --> 广度遍历(多叉树)
    public static void noRecursionBfs(List<TreeNode> children, int depth) {
        List<TreeNode> thisChildren = new ArrayList<>();
        List<TreeNode> allChildren = new ArrayList<>();
        for (TreeNode child: children) {
            //打印节点值，还可以打印深度
            System.out.print(child.data + " ");
            thisChildren = child.childNodes;
            if (thisChildren != null && thisChildren.size() > 0) {
                allChildren.addAll(thisChildren);
            }
        }
        if (allChildren.size() > 0)  {
            noRecursionBfs(allChildren, depth + 1);
        }
    }

    // 非递归版 --> 广度遍历(多叉树)
    private static void recursionBfs(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data + " ");
            for (int i = 0; i < node.childNodes.size(); i++) {
                queue.offer(node.childNodes.get(i));
            }
            // 如果是二叉树，就像下面这样写，如果是普通点的多叉树只是变成for循环罢了
//            if (tree.left != null)
//                queue.offer(tree.left);
//            if (tree.right != null)
//                queue.offer(tree.right);
        }
    }
}

