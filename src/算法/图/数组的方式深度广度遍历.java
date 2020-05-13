package 算法.图;

public class 数组的方式深度广度遍历 {

    public static void main(String[] args) {
        数组的方式深度广度遍历 test = new 数组的方式深度广度遍历();
        System.out.println("深度遍历开始：");
        test.dfsTraversing(0, graph);
    }


    static int[][] graph = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}};
    // 用来记录已经遍历过的元素
    int[] visited = new int[graph.length];

    //DFS(深度优先遍历)同样适用于有向图 A->C->B->D->E->F 即 0->2->1->3->4->5
    public void dfsTraversing(int node, int[][] graph) {
        visited[node] = 1;
        System.out.println("查找的节点是：" + node);
        for (int i = 0; i < graph[node].length; ++i) {
            if (visited[i] == 0 && i != node && graph[node][i] == 1) {
                dfsTraversing(i, graph);
            }
        }
    }

    //BFS(广度优先遍历)同样适用于有向图 A->C->D->B->E->F 即0->2->3->1->4->5
    public void bfsTraversing(int[][] graph) {
        int[] queue = new int[graph.length];
        int cnt = 1;
        // 将A作为起始顶点加入队列
        queue[0] = 0;
        // 标记第一个已经遍历过
        visited[0] = 1;
        System.out.println(0);
        for (int i = 0; i < cnt; ++i) {
            for (int j = 0; j < graph[queue[i]].length; ++j) {
                if (queue[i] != j && graph[queue[i]][j] == 1 && visited[j] == 0) {
                    visited[queue[i]] = 1;
                    queue[cnt++] = j;
                    System.out.println(j);
                }
            }
        }
    }
}
