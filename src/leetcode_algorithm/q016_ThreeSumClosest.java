package leetcode_algorithm;

import java.util.Arrays;


/**

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
        Return the sum of the three integers. You may assume that each input would have exactly one solution.

*/


public class q016_ThreeSumClosest {


    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1 , 2 , -1 , -4} , 2) );
    }

    /**
     * ½â·¨1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2;i++) {
            int start = i + 1,  end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    end--;
                }else {
                    start ++;
                }

            }
        }
        return result;
    }


}
