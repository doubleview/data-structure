package leetcode_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */

public class q090_SubSets2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        q090_SubSets2 solution = new q090_SubSets2();
        System.out.println(solution.subsetsWithDup(nums));
    }

    /**
     * 解法1 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, list, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
