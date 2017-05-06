package leetcode_algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
     * 解法1
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

    /**
     * 解法2
     * @param nums
     * @return
     */
    public int loggestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int max = 1;
        for (int num : nums) {
            if(set.remove(num)){
                int val = num;
                int sum = 1;
                while (set.remove(val-1)) val--;
                sum+=num-val;

                val = num;
                while (set.remove(val+1))val++;

                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
