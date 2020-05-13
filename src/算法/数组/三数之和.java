package 算法.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 示例：
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
//        System.out.println(lists);
    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//
//        int[] verbose = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> find = new ArrayList<>();
//            while (i > 0 && nums[i - 1] == nums[i]) {
//                i++;
//            }
//            find.add(nums[i]);
//            int leftSum = -nums[i];
//
//            int index = 0;
//            for (int j = 0; j < nums.length; j++) {
//                verbose[index++] = leftSum - nums[j];
//            }
//
//            boolean hasMore = false;
//            int start = i + 1;
//            int end = verbose.length - 1;
//            while (start < nums.length && end >= 0 && start < end) {
//                if (nums[start] < verbose[end]) {
//                    start++;
//                } else if (nums[start] > verbose[end]) {
//                    end--;
//                } else {
//                    if (hasMore) {
//                        find = new ArrayList<>();
//                        find.add(nums[i]);
//                    }
//                    find.add(nums[start]);
//                    find.add(leftSum - verbose[end]);
//                    System.out.println(find);
//                    result.add(find);
//                    start++;
//                    end--;
//                    hasMore = true;
//                }
//            }
//        }
//        return result;
//    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    ans.add(list);
                    left++;
                    while (left + 1 < right && nums[left -1] == nums[left]) left++;
                    right--;
                    while (left < right - 1 && nums[right + 1] == nums[right]) right--;

//                    while(left+1<right && nums[left]==nums[left+1]) left++;
//                    while(left<right-1 && nums[right-1]==nums[right]) right--;
//                    left++;
//                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
