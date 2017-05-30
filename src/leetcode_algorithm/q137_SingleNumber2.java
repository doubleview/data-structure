package leetcode_algorithm;

import java.util.Arrays;

/**

Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

        Note:
        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class q137_SingleNumber2 {

    public static void main(String[] args) {
        q137_SingleNumber2 solution = new q137_SingleNumber2();
        System.out.println(solution.singleNumber2(new int[]{2 , 2 , 2 , 4 , 5 , 4 , 4 , 5 , 5 , 7 , 8 , 8 , 8}));
    }

    /**
     * 解法1
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
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
