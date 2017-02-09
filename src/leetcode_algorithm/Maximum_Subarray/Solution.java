package leetcode_algorithm.Maximum_Subarray;

/**

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

        For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
        the contiguous subarray [4,-1,2,1] has the largest sum = 6.

*/

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
        System.out.println(new Solution().maxSubArray(new int[]{-1}));
        System.out.println(new Solution().maxSubArray(new int[]{-3 , 1 , -2}));
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int smax = Integer.MIN_VALUE;
        for (int n : nums) {
            sum+=n;
            if(sum > smax) smax = sum;
            if(sum < 0) sum = 0;
        }
        return smax;
    }


}
