package 算法.树;

/**
 * 树是否对称
 */
public class IsSymmetrical extends BaseTree {

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = buildTreeNode();
        boolean symmetrical = isSymmetrical(binaryTreeNode, binaryTreeNode);
        System.out.println(symmetrical);
    }

    public static BinaryTreeNode buildTreeNode() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(9);
        root.right = new BinaryTreeNode(9);
//        root.left.left = new TreeNode(9);
//        root.left.right = new TreeNode(2);
//        root.left.right.left = new TreeNode(4);
//        root.left.right.right = new TreeNode(7);
        return root;
    }

    public static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        /** root1， root2 皆存在 */
        if (root1.data != root2.data) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }


}
