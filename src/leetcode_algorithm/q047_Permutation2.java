package leetcode_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

        For example,
        [1,1,2] have the following unique permutations:
        [
        [1,1,2],
        [1,2,1],
        [2,1,1]
        ]

*/

public class q047_Permutation2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2 , 2};
        System.out.println(new q047_Permutation2().permuteUnique(nums));
    }

    /**
     * 解法1(推荐解法)
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, used , new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, boolean[] used , List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
                list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) continue;
                if(i >0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list,  used , tempList, nums);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


}
