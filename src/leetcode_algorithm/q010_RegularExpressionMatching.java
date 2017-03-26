package leetcode_algorithm;

/**

'.' Matches any single character.
        '*' Matches zero or more of the preceding element.

        The matching should cover the entire input string (not partial).

        The function prototype should be:
        bool isMatch(const char *s, const char *p)

        Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "a*") ¡ú true
 isMatch("aa", ".*") ¡ú true
 isMatch("ab", ".*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú true
*/

public class q010_RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(isMathc("ab" , "a"));
        System.out.println(isMathc("aa" , "aa"));
        System.out.println(isMathc("aa" , ".*"));
        System.out.println(isMathc("ab" , ".*"));
        System.out.println(isMathc("aab" , "c*a*b"));
        System.out.println(isMathc("aa" , "a*"));
        System.out.println(isMathc("aab" , "aab*"));
    }


    /**
     * ½â·¨1
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMathc(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for(int i = 0;i<p.length();i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i+1] = true;
            }
        }

        for(int i = 0;i < s.length();i++) {
            for(int j = 0;j < p.length();j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
