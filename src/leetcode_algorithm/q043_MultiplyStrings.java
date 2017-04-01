package leetcode_algorithm;


import java.util.Arrays;

/**
 *
 */
public class q043_MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(new q043_MultiplyStrings().multiply("444", "32"));
    }

    /**
     * 解法1 (推荐解法 图解法)
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
                System.out.println(Arrays.toString(pos));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


}
