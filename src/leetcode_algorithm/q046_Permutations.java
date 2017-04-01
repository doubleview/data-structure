package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;


/**
Given a collection of distinct numbers, return all possible permutations.

        For example,
        [1,2,3] have the following permutations:
        [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
        ]

*/

public class q046_Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new q046_Permutations().permute(nums));
    }

    /**
     * 解法1(推荐解法)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // ArraySort.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
