package leetcode_algorithm;


import java.util.Arrays;

/**
 * Total Accepted: 153042
 * Total Submissions: 409130
 * Difficulty: Easy
 * Contributors: Admin
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 */

public class q066_PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new q066_PlusOne().plusOne(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new q066_PlusOne().plusOne(new int[]{1, 2, 3, 9})));
        System.out.println(Arrays.toString(new q066_PlusOne().plusOne(new int[]{9, 9, 9, 9})));
    }

    /**
     * 解法1(个人解法)
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

}
