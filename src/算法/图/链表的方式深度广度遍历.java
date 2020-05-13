package 算法.图;

import java.util.*;

public class 链表的方式深度广度遍历 {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");

        Relation ab = new Relation(a, b);
        Relation ac = new Relation(a, c);
        Relation ad = new Relation(a, d);
        Relation ah = new Relation(a, h);
        Relation bc = new Relation(b, c);
        Relation de = new Relation(d, e);
        Relation ef = new Relation(e, f);
        Relation eg = new Relation(e, g);
        Relation hg = new Relation(h, g);

        //建立它们的关系
        a.relations.add(ab);
        a.relations.add(ac);
        a.relations.add(ad);
        a.relations.add(ah);
        b.relations.add(bc);
        d.relations.add(de);
        e.relations.add(ef);
        e.relations.add(eg);
        h.relations.add(hg);

        //广度遍历
        System.out.println("广度遍历如下：");
        widthSearch(a);

        //深度遍历
        System.out.println("深度遍历如下：");
        List<Node> visited = new ArrayList<>();
        deptFirstSearch(a, visited);
    }

    private static void deptFirstSearch(Node node, List<Node> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        System.out.println("查找的节点是：" + node.word);

        for (int i = 0; i < node.relations.size(); i++) {
            Node nextNode = node.relations.get(i).end;
            deptFirstSearch(nextNode, visited);
        }

    }

    private static void widthSearch(Node start) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            if (visited.contains(currentNode)) {
                continue;
            }

            visited.add(currentNode);
            System.out.println("查找的节点是：" + currentNode.word);
            for (int i = 0; i < currentNode.relations.size(); i++) {

                Node nextNode = currentNode.relations.get(i).end;
                q.offer(nextNode);
            }
        }
    }

}

class Node {
    String word;
    List<Relation> relations;

    public Node(String word) {
        this.word = word;
        relations = new ArrayList<>();
    }
}

class Relation {
    Node start, end; /* 开始点，结束点 */

    public Relation(Node start, Node end) {
        this.start = start;
        this.end = end;
    }
}
