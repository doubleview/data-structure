package leetcode_algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 * <p>
 * Subscribe to see which companies asked this question.
 */

public class q060_PermutationSequence {

    public static void main(String[] args) {
        System.out.println(new q060_PermutationSequence().getPermutation(3, 3));
    }

    /**
     *  解法1(个人解法)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i * fact[i - 1];
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int ind = k / fact[i];
            k = k % fact[i];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }

}
