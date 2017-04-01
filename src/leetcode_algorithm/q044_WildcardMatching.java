package leetcode_algorithm;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "*") ¡ú true
 * isMatch("aa", "a*") ¡ú true
 * isMatch("ab", "?*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú false
 */


public class q044_WildcardMatching {


    public static void main(String[] args) {
        System.out.println(new q044_WildcardMatching().isMatch("aa", "a"));
        System.out.println(new q044_WildcardMatching().isMatch("aa", "aa"));
        System.out.println(new q044_WildcardMatching().isMatch("aaa", "aa"));
        System.out.println(new q044_WildcardMatching().isMatch("aa", "*"));
        System.out.println(new q044_WildcardMatching().isMatch("aa", "a*"));
        System.out.println(new q044_WildcardMatching().isMatch("aa", "?*"));
        System.out.println(new q044_WildcardMatching().isMatch("aab", "c*a*b"));
    }

    /**
     * ½â·¨1
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*') break;
            else match[s.length()][i] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                else match[i][j] = false;
            }
        }
        return match[0][0];
    }

}
