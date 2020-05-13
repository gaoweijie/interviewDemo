package 算法.树;

import java.util.*;

public class BaseTree {

    static class BinaryTreeNode {
        int data; // 数据域
        BinaryTreeNode left;// 左子节点
        BinaryTreeNode right; // 右子节点

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    static class TreeNode {
        String data; // 数据域
        List<TreeNode> childNodes = new ArrayList<>();// 左子节点

        public TreeNode(String data) {
            this.data = data;
        }
    }

}
