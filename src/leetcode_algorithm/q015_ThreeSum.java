package leetcode_algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**

    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     Find all unique triplets in the array which gives the sum of zero.

*/

public class q015_ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-6,-8,-9,4,-14,6,-10,7,12,13,4,9,7,14,-12,7,0,14,-1,-3,2,2,-3,11,-6,-10,-13,-13,1,-9,2,2,-2,8,-9,0,-9,-12,14,10,8,3,4,0,-6,7,14,9,6,-2,13,-15,8,-5,3,-13,-8,5,-11,0,11,6,-13,-14,-9,-15,-7,-11,10,-7,14,4,3,3,11,13,-13,11,-1,0,-6,-10,0,9,0,10,11,0,0,-14,-15,-12,-1,10,12,-2,2,-10,2,-2,-10,2,-13,1,12,5,-1,-15,1,5,-8,3,10,8}));
    }

    /**
     * 个人解法
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> sums = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 ; i++) {
            for(int j = i+1; j < nums.length - 1 ;j++) {
                for (int k = j + 1; k < nums.length;k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        Collections.sort(integers);
                        if (!sums.contains(integers))
                            sums.add(integers);
                    }
                }
            }
        }
        return sums;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i= 0; i+2 < nums.length;i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int j = i + 1, k  = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) j++;
                    while (j<k && nums[k] == nums[k+1]) k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return res;
    }
}
