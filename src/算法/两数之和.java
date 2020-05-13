package 算法;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class 两数之和 {

    public static void main(String[] args) {

    }

    public static int[] getTwoIndex(int[] nums, int target) {
        Map map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

            if (map.containsKey(nums[i] - target)) {
                result[0] = (int) map.get(nums[i]);
                result[1] = i;
            }
        }
        return result;
    }

}
