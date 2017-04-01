package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class q077_Combinations {


    public static void main(String[] args) {
        System.out.println(new q077_Combinations().combine(4, 2));
    }

    /**
     * 解法1(个人解法)
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), n, k, 0);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i <= index) continue;
            list.add(i);
            combine(result, list, n, k, i);
            list.remove(list.size() - 1);
        }
    }

}
