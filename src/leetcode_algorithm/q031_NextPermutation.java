package leetcode_algorithm;


import java.util.Arrays;

/**

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

        If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

        The replacement must be in-place, do not allocate extra memory.

        Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 ¡ú 1,3,2
 3,2,1 ¡ú 1,2,3
 1,1,5 ¡ú 1,5,1

*/

public class q031_NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1 , 2 , 5, 4, 3, 2 ,1};
        new q031_NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * ½â·¨1
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length<=1) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i]>=nums[i+1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums , i , j);
        }
        reverse(nums , i+1 , nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums , i++ , j--);
    }

}
