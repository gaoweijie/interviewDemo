package 算法.字符串;

/**
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

/** num1 * num2 位数最多 num1+num2
 * 假设结果为 num1+num2 位，则 num1[i]*num[j] 结果作用于结果位 i+j,i+j+1
 *
 *       1 2 3
 *       4 5 6
 * ————————————
 *         1 8
 *       1 2
 *     0 6
 * ------------
 *       1 5
 *     1 0
 *   0 5
 * ------------
 *     1 2
 *   0 8
 * 0 4
 * ------------
 * 0 1 2 3 4 5
 */
public class 字符串相乘 {

    public static void main(String[] args) {
        字符串相乘 test = new 字符串相乘();
        String num1 = "75498";
        String num2 = "32";
        String multiply = test.multiply(num1, num2);
        System.out.println(multiply);
        //4128
    }


    public String multiply2(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }

        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) {
            return "0";
        }

        int k = 0;

        int[] result = new int[num2.length() + num1.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int resultIndex = k++;
            int needAdd = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int singleMultiply = (Integer.parseInt(String.valueOf(num2.charAt(i)))) * (Integer.parseInt(String.valueOf(num1.charAt(j))));

                int currentNum = result[resultIndex] + singleMultiply + needAdd;
                //当前位的值
                result[resultIndex] = currentNum % 10;
                // 需要进位的值
                needAdd = currentNum / 10;
                resultIndex++;
            }
            result[resultIndex] = needAdd;
            print(result);
        }

        StringBuffer sb = new StringBuffer();
        int i;
        for (i = result.length - 1; result[i] == 0 && i >= 0; i--) {
        }
        for (int j = i; j >= 0; j--) {
            sb.append(result[j]);
        }
        return sb.toString();
    }


    public String multiply(String str1, String str2) {
        int[] res = new int[str1.length() + str2.length()];
        if (str1.equals("0") || str2.equals("0"))
            return "0";
        for (int i = str1.length() - 1; i >= 0; i--) {
            int tmp1 = str1.charAt(i) - '0';
            for (int j = str2.length() - 1; j >= 0; j--) {
                int tmp2 = str2.charAt(j) - '0';
                int sum = tmp1 * tmp2 + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            result.append(res[i]);
        }
        return result.toString();
    }

    private void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }


}
