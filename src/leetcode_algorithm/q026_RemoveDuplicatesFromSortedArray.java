package leetcode_algorithm;


/**

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

        Do not allocate extra space for another array, you must do this in place with constant memory.

        For example,
        Given input array nums = [1,1,2],

        Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

*/

public class q026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1 , 1 , 2}));
    }

    /**
     * 解法1 推荐解法
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i]!=nums[j]){
                nums[++j] = nums[i];
            }
        }
        return  ++j;
    }


}
