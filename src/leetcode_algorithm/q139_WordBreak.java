package leetcode_algorithm;


import java.util.ArrayList;
import java.util.List;

/**

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 You may assume the dictionary does not contain duplicate words.

        For example, given
        s = "leetcode",
        dict = ["leet", "code"].

        Return true because "leetcode" can be segmented as "leet code".
*/

public class q139_WordBreak {


    public static void main(String[] args) {
        q139_WordBreak solution = new q139_WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean isWordBreak = solution.wordBreak("leetcode", wordDict);
        System.out.println(isWordBreak);


        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("a");
        System.out.println(solution.wordBreak("aaaa", wordDict2));
    }

    /**
     * ½â·¨1
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1;i<=s.length();i++) {
            for(int j = 0;j<i;j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }


}
