package leetcode_algorithm;

import java.util.HashMap;
import java.util.Map;

/**

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

        For example,
        Given [100, 4, 200, 1, 3, 2],
        The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

        Your algorithm should run in O(n) complexity.

        Subscribe to see which companies asked this question.

*/

public class q128_LongestConsecutiveSequence {


    public static void main(String[] args) {
        q128_LongestConsecutiveSequence solution = new q128_LongestConsecutiveSequence();
        System.out.println(solution.loggestConsecutive(new int[]{100 , 4 , 200 , 1 , 3 , 2}));
    }

    /**
     * ½â·¨1
     * @param nums
     * @return
     */
    public int loggestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1) ? map.get(n - 1) : 0);
                int right = (map.containsKey(n + 1) ? map.get(n + 1) : 0);
                int sum = left + right+1;
                map.put(n, sum);
                res = Math.max(res, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }

}
