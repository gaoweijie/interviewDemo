package 算法.字符串;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class 最大子序和 {

    public static void main(String[] args) {
        最大子序和 test = new 最大子序和();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = test.maxSubArray(nums);
        System.out.println(i);
    }

    /**
     *  思路：当 a+b+c+d<d  ==> a+b+c+d+e<d+e  ==>  a开始的序列小于d开始的序列，是否从b开始继续往后检索？
     *  如果能走到a+b+c+d<d的条件说明之前a+b>=b,即a是非负数，同理，abc都是非负数
     *  那么没必要从b开始往后检索了，直接从d开始检索
     *
     * @param arr
     * @return
     */
    public int maxSubArray(int[] arr) {
        // 可能的最大子序和
        int max = arr[0];
        // 当前累加值
        int currSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max((currSum + arr[i]), arr[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }


}
