package 算法.字符串;

import java.util.ArrayList;
import java.util.List;

public class 排列组合 {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] dict = new int[4];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = i + 1;
        }
        recur(dict, 0, 3, result, new ArrayList<>());
        System.out.println(result);
        System.out.println(result.size());
    }

//    public List<List<Integer>> a(int n, int k) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < n; j++) {
//                if (temp.size() == k) {
//                    result.add(temp);
//                    temp.clear();
//                }
//                if (temp.contains(j+1)) {
//                    continue;
//                } else {
//                    temp.add()
//                }
//
//            }
//        }
//
//    }

    /**
     * 递归
     *
     * @param dict      字典
     * @param level     每次下探一层(0 <= level < k)
     * @param k         K为边界
     * @param result    最终结果
     * @param generated 每一轮生成的结果
     */
    public static void recur(int[] dict, int level, int k, List<List<Integer>> result, ArrayList<Integer> generated) {
        if (level == k) {
            if (generated.size() == k) {
                result.add(generated);
            }
            return;
        }

        recur(dict, level + 1, k, result, generated);

        for (int i = 0; i < dict.length; i++) {
            if (generated.size() < k && !generated.contains(dict[i])) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (Integer item : generated) {
                    temp.add(item);
                }
                temp.add(dict[i]);
                recur(dict, level + 1, k, result, temp);
            }
        }
    }

}
