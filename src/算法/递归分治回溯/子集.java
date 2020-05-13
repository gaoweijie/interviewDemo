package 算法.递归分治回溯;

import java.util.ArrayList;
import java.util.List;


public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null) {
            return ans;
        }
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index) {
        // 1. recursion terminator
        if (index == nums.length) {
            ans.add(new ArrayList<>(list)); // 拷贝出来的一份list，不要影响原来的list
            return;
        }

        // 2. process(split your big problem) / prepare data （处理当前逻辑，就是把这个大问题如何分成子问题）
        // 3. conquer subproblems （调用这个函数下探一层，解决更细节的子问题）
        dfs(ans, nums, list, index + 1);    //index位置的元素选
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);    //index位置的元素不选

        // 4. revert the current level status if needed（此处不需要）
        list.remove(list.size() - 1);
    }
}
