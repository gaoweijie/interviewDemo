package 算法.数组;

import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * TODO 待理解
 */
public class 接雨水 {

    public static int solution(int[] height) {
        int ans = 0, current = 0;
        LinkedList<Integer> st = new LinkedList<Integer>();
        while (current < height.length) {
            // 一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到ans
            while (!st.isEmpty() && height[current] > height[st.getLast()]) {
                int top = st.removeLast();
                if (st.isEmpty())
                    break;
                int distance = current - st.getLast() - 1;
                int bounded_height = Math.min(height[current], height[st.getLast()]) - height[top];
                ans += distance * bounded_height;
            }
            // 存索引，表示后面到这里面的索引之间有位置可以接雨水
            st.addLast(current++);
        }
        return ans;
    }

}
