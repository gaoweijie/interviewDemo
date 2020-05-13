package 算法;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class 两数相加 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next =  new ListNode(4);
        node1.next.next =  new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next =  new ListNode(6);
        node2.next.next =  new ListNode(4);

        ListNode result = getSumNode2(node1, node2);
        System.out.println(result);
    }

    public static ListNode getSumNode2(ListNode node1, ListNode node2) {
        ListNode resultNode = new ListNode(0);
        ListNode head = resultNode;
        int addOne = 0;
        while (node1!= null || node2!= null) {
            int v1 = node1 == null ? 0 : node1.val;
            int v2 = node2 == null ? 0 : node2.val;
            int newVal = (v1 + v2 + addOne) % 10;
            addOne = (v1 + v2 + addOne) /10;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;

            /** 进行尾插法插入 */
            ListNode insertNode = new ListNode(newVal);
            resultNode.next = insertNode;
            resultNode = insertNode;
        }
        if (addOne == 1) {
            ListNode insertNode = new ListNode(1);
            resultNode.next = insertNode;
            resultNode = insertNode;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
