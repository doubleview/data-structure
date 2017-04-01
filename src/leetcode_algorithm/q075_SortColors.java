package leetcode_algorithm;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */

public class q075_SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 2, 0, 1};
        new q075_SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2, 1, 0, 2, 0, 1, 0, 2, 1};
        new q075_SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * ½â·¨1
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }


}
