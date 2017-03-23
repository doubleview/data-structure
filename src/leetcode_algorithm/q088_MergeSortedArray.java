package leetcode_algorithm;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 * hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */

public class q088_MergeSortedArray {

    public static void main(String[] args) {
        q088_MergeSortedArray solution = new q088_MergeSortedArray();
        int[] num1 = new int[]{1, 3, 6, 7, 9, 12, 23, 45, 56, 89, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] num2 = new int[]{2, 4, 10, 18, 32, 89};
        solution.merge(num1, 6, num2, 6);
        System.out.println(Arrays.toString(num1));
    }


    /**
     * ½â·¨1
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        while (j > -1) nums1[k--] = nums2[j--];
    }

}
