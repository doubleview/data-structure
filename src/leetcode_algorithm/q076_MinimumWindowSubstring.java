package leetcode_algorithm;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * <p>
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * <p>
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class q076_MinimumWindowSubstring {

    public static void main(String[] args) {
        q076_MinimumWindowSubstring solution = new q076_MinimumWindowSubstring();

        System.out.println(solution.minWindow("ADOBECODEBANC", "BANC"));
        int i = 0;
        System.out.println(i++ == 1);
    }


    /**
     * 解法1(推荐解法)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] tmap = new int[128];
        for (int c : t.toCharArray()) tmap[c]++;
        int count = t.length(), begin = 0, end = 0, minLen = Integer.MAX_VALUE, leftMin = 0;
        while (end < s.length()) {
            if (tmap[s.charAt(end++)]-- > 0) count--;
            while ((count == 0)) {
                if (end - begin < minLen) minLen = end - (leftMin = begin);
                if (++tmap[s.charAt(begin++)] > 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(leftMin, leftMin + minLen);
    }

}
