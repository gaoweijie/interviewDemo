package 算法.树;

public class 二叉树的递归 {


    /** 前序/先序遍历 */
    public void find(BaseTree.BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        find(node.left);
        find(node.right);
    }



}
