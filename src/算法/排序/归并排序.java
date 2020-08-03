package 算法.排序;

import 算法.BaseSort;

public class 归并排序 extends BaseSort {

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 4, 5, 6, 9, 7, 8};
        sort(a);
        print(a);

//        int[] b = {4, 2, 3, 4, 3, 6, 3, 2, 8};
//        sort(b);
//        print(b);
    }

    private static void sort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);
    }

    private static void sort(int[] a, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) >> 1;
            sort(a, low, mid, temp);
            sort(a, mid + 1, high, temp);
            merge(a, low, mid, high, temp);
        }
    }

    private static void merge(int[] a, int low, int mid, int high, int[] temp) {
        int i = low;
        int j = mid + 1;
        int tempIndex = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[tempIndex++] = a[i++];
            } else {
                temp[tempIndex++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[tempIndex++] = a[i++];
        }
        while (j <= high) {
            temp[tempIndex++] = a[j++];
        }
        // 回写到原数组
        for (int p = 0; p < tempIndex; p++) {
            a[low + p] = temp[p];
        }
    }
}
