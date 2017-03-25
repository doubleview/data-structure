package leetcode_algorithm;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */

public class q091_DecodeWays {

    public static void main(String[] args) {
        q091_DecodeWays solution = new q091_DecodeWays();
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("123"));
        System.out.println(solution.numDecodings("0"));
        System.out.println(solution.numDecodings("10"));
    }

    /**
     * ½â·¨1
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;

        for (int i = 2; i < len + 1; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int val = Integer.valueOf(s.substring(i - 2, i));
            if (val >= 10 && val <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }

}
