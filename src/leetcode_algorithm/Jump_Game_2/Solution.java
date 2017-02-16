package leetcode_algorithm.Jump_Game_2;



public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().jump2(new int[]{2, 3, 1, 1, 4}));
    }


    /**
     * 个人解法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        int max = nums[0];
        int edge = 0;
        for(int i = 1; i<nums.length ;i++) {
            if (i > edge) {
                edge = max;
                step++;
                if(edge >= nums.length - 1)
                    return step;
            }
            max = Math.max(max, i + nums[i]);
        }
        return step;
    }


    /**
     *其他解法
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int maxReach = nums[0];
        int edge = 0;
        int minstep = 0;

        for(int i = 1 ; i< nums.length; i++) {
            if (i > edge) {
                minstep += 1;
                edge = maxReach;
                if(edge > nums.length - 1)
                    return minstep;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
            if(maxReach == i)
                return -1;
        }
        return minstep;
    }


}
