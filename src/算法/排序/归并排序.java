package 算法.排序;

import 算法.BaseSort;

public class 归并排序 extends BaseSort {

    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 1, 4, 5, 6, 9, 7, 8};
        sort(a);
        print(a);
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
                temp[tempIndex++] = a[i];
                i++;
            } else {
                temp[tempIndex++] = a[j];
                j++;
            }
//            if (a[i] >= a[j]) {
//                temp[tempIndex++] = a[j];
//                j++;
//            }
        }
        if (i <= mid) {
            for (int k = i; k <= mid; k++) {
                temp[tempIndex++] = a[k];
            }
        }
        if (j <= high) {
            for (int k = j; k <= high; k++) {
                temp[tempIndex++] = a[k];
            }
        }
        int t = 0;
        while (low <= high) {
            a[low++] = temp[t++];
        }
    }
}
