package 算法;

/**
 * 数组前K大的数
 */
public class FindMaxKIndexDemo extends BaseSort {

    public static int sortOnce(int[] arr, int low, int high, int k) {
        int compareIndex = arr.length - k;

        // 基准位置
        int index = low;
        int key = arr[low];

        int i = low;
        int j = high;

        while (i < j) {
            for (; i < j && arr[j] >= key; ) {
                j--;
            }
            for (; i < j && arr[i] <= key; ) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, index, i);
        index = i;
        print(arr);

        System.out.println("当前基准位置=" + index + ", value=" + arr[i]);
        if (index == compareIndex) {
            return arr[index];
        } else if (index < compareIndex) {
            return sortOnce(arr, index + 1, high, k);
        } else {
            return sortOnce(arr, low, index - 1, k);
        }
    }

    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8 9 10
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int result = sortOnce(arr, 0, arr.length - 1, 4);
        System.out.println(result);
    }

}
