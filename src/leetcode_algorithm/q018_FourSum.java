package leetcode_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

*/

public class q018_FourSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1 , 0 , -1 , 0 , -2 , 2}, 0));
        System.out.println(fourSum(new int[]{0 , 0 , 0 , 0}, 0));
        System.out.println(fourSum(new int[]{-5,-4,-2,-2,-2, -1, 0, 0, 1}, -9));
    }

    /**
     * 解法1(个人解法)
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i + 3< nums.length;i ++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1; j + 2 < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j - 1])
                    continue;
                int result = target - nums[i] - nums[j];
                int k = j+1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[k] + nums[l] == result) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k<l && nums[k] == nums[k-1]) k++;
                        while (k<l && nums[l] == nums[l+1]) l--;
                    } else if (nums[k] + nums[l] > result) {
                        l--;
                    }else {
                        k++;
                    }
                }
            }
        }
        return list;
    }

}
