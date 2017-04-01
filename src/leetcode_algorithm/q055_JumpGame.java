package leetcode_algorithm;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */

public class q055_JumpGame {

    public static void main(String[] args) {
        System.out.println(new q055_JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new q055_JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }


    /**
     * 解法1(个人解法)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max == i) break;
        }
        return max >= nums.length - 1;
    }


}
