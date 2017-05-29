package leetcode_algorithm;

import java.util.Arrays;

/**

Given an array of integers, every element appears twice except for one. Find that single one.

        Note:
        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class q136_SingleNumber {

    public static void main(String[] args) {
        q136_SingleNumber solution = new q136_SingleNumber();
        System.out.println(solution.singleNumber(new int[]{3 , 4 , 3 , 4 , 6 , 6 , 5}));
    }

    /**
     * 解法1(个人解法)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1 || nums[0]!=nums[1]){
            return nums[0];
        }
        int index = 1;
        while (index < nums.length-1) {
            if(nums[index]!=nums[index-1] && nums[index]!=nums[index+1])
                return nums[index];
            index++;
        }
        return nums[nums.length - 1];
    }

    /**
     * 解法2(推荐解法)
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}
