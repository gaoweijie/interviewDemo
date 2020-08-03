package 算法.并查集;

public class Solution {
    int[] father = new int[4];
    {
        father[0] = 0;
        father[1] = 0;
        father[2] = 1;
        father[3] = 2;
    }

    int find(int x) {
        if (father[x] != x) father[x] = find(father[x]);
        return father[x];
    }


    int[] nums = new int[4];
    {
        nums[0] = 0;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 2;
    }

    int find2(int k) {
        int i = k, j = k;
        while (i != nums[i]) i = nums[i]; //Here i is the ancester.
        while (nums[j] != i) {  // update the whole path to connect to the ancester directly.
            int t = nums[j];
            nums[j] = i;
            j = t;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.find(3));
        System.out.println(solution.find2(3));
    }

}
