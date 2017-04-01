package leetcode_algorithm;

/**

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

        For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
        the contiguous subarray [4,-1,2,1] has the largest sum = 6.

*/

public class q053_MaximunSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new q053_MaximunSubarray().maxSubArray(nums));
        System.out.println(new q053_MaximunSubarray().maxSubArray(new int[]{-1}));
        System.out.println(new q053_MaximunSubarray().maxSubArray(new int[]{-3, 1, -2}));
    }

    /**
     * 解法1(推荐解法)
     *
     * @param nums
     * @return
     */
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
