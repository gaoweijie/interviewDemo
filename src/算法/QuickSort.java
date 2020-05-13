package 算法;

/**
 * 快排
 */
public class QuickSort extends BaseSort {


    public static void sort(int[] arr, int low, int high) {
        // 枢纽轴
        int index = low;
        // 基准value值
        int key = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            /** for循环只能一开始从右往左：原因是第一趟排序的时候目的是枢纽轴与一个小的值交换，所以一定要最终停留在的是小的值，而从左往右是找的大的值会导致停留的地方是大的值，故不可以 */
            for (; j > i & arr[j] >= key; ) {
                j--;
            }
            for (; i < j & arr[i] <= key; ) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, index, i);
        print(arr);
        index = i;

        //迭代
        if (index != high) {
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(arr, 0, arr.length - 1);
        // 1 2 3 4 5 6 7 8 9 10
    }

}
