package leetcode_algorithm;


/**

Given an array and a value, remove all instances of that value in place and return the new length.

        Do not allocate extra space for another array, you must do this in place with constant memory.

        The order of elements can be changed. It doesn't matter what you leave beyond the new length.

        Example:
        Given input array nums = [3,2,2,3], val = 3

        Your function should return length = 2, with the first two elements of nums being 2.

*/

public class q027_RemoveElement {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums , 3));
        System.out.println(nums);
    }

    /**
     * 解法1 推荐解法
     * @param nums
     * @param val
     * @return
     */
    public static  int removeElement(int[] nums, int val) {
        int m  = 0;
        for(int i = 0;i<nums.length;i++) {
            if (nums[i] != val) {
                nums[m] = nums[i];
                m++;
            }
        }
        return m;
    }

}
