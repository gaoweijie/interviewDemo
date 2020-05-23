package 算法.leetcode.editor.cn;

import java.util.Arrays;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
// 
// Related Topics 数组 双指针
public class 最接近的三数之和 {
    public static void main(String[] args) {
        Solution solution = new 最接近的三数之和().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        if (target - nums[i] - nums[j] - nums[k] < diff) {
                            diff = target - nums[i] - nums[j] - nums[k];
                            res = nums[i] + nums[j] + nums[k];
                        }
                        j++;
                    } else if (nums[i] + nums[j] + nums[k] > target) {
                        if (nums[i] + nums[j] + nums[k] - target < diff) {
                            diff = nums[i] + nums[j] + nums[k] - target;
                            res = nums[i] + nums[j] + nums[k];
                        }
                        k--;
                    } else {
                        return target;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}