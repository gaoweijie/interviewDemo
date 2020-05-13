package 算法.树;

public class 树的深度遍历 extends BaseTree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        a.childNodes.add(b);
        a.childNodes.add(e);
        b.childNodes.add(c);
        b.childNodes.add(d);
        e.childNodes.add(f);

        find(a);
    }

    public static void find(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        // 优先找左子树
        if (!node.childNodes.isEmpty()) {
            for (int i = 0; i < node.childNodes.size(); i++) {
                find(node.childNodes.get(i));
            }
        }

    }
}
