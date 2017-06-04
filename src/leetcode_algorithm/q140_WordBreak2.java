package leetcode_algorithm;

import java.util.*;

/**

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

        Return all such possible sentences.

        For example, given
        s = "catsanddog",
        dict = ["cat", "cats", "and", "sand", "dog"].

        A solution is ["cats and dog", "cat sand dog"].

*/

public class q140_WordBreak2 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        q140_WordBreak2 solution = new q140_WordBreak2();
        System.out.println(solution.wordBreak2("catsanddog" , wordDict));
    }


    /**
     * 解法1(个人解法)
     */
    List<String> resultList;
    public List<String> wordBreak(String s, List<String> wordDict) {
        resultList = new ArrayList<>();
        wordBreak(resultList, new StringBuilder(), s, 0, wordDict);
        return resultList;
    }


    private void wordBreak(List<String> resultList, StringBuilder result , String s, int index , List<String> wordDict) {

        if (index == s.length()) {
            resultList.add(result.toString().trim());
        }

        for(int i = index+1; i<=s.length();i++) {
            if (wordDict.contains(s.substring(index, i))) {
                result.append(s.substring(index, i)).append(" ");
                wordBreak(resultList, result, s, i, wordDict);
                result.delete(result.length() - i + index - 1, result.length());
            }
        }
    }


    /**
     * 解法2
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<>());
    }

    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
