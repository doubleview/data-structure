package leetcode_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

        Each number in C may only be used once in the combination.

        Note:
        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.
        For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
        A solution set is:
        [
        [1, 7],
        [1, 2, 5],
        [2, 6],
        [1, 1, 6]
        ]

*/

public class q040_CombinationSum2 {

    public static void main(String[] args) {
        System.out.println(new q040_CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    /**
     * 解法1(个人解法)
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationChild(candidates , target , 0 , list , new ArrayList<>());
        return list;
    }

    private void combinationChild(int[] candidates , int target  , int index , List<List<Integer>> result , List<Integer> list){
        if(target == 0) result.add(new ArrayList<>(list));
        for(int i =index ;i<candidates.length ;i++) {
            if(i != index && candidates[i] == candidates[i-1]) continue;
            if(target < candidates[i]) return;
            list.add(candidates[i]);
            combinationChild(candidates , target - candidates[i] , i+1 , result , list);
            list.remove(list.size() - 1);
        }
    }

}
