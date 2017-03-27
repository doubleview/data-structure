package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;

/**

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

        For example, given n = 3, a solution set is:
*/

public class q022_GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }

    /**
     * 解法1 (个人解法)
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        return appendString("(", 1, n);
    }

    private static List<String> appendString(String s , int leftCount , int n) {
        if (n*2 == s.length() ) {
            List<String> list = new ArrayList<>();
            list.add(s.toString());
            return list;
        }
        if (leftCount == n) {
            return appendString(s+")", leftCount , n);
        }else if(leftCount*2 == s.length()){
            return appendString(s+"(", ++leftCount, n);
        }else {
            List<String> s1 = appendString(s+")", leftCount, n);
            List<String> s2 = appendString(s+"(", ++leftCount, n);
             s1.addAll(s2);
            return s1;
        }
    }

    /**
     * 解法2 (推荐解法)
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list , "" , 0 , 0 , n);
        return list;
    }


    public void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list , str + "(" , open+1 , close , max);
        if(close < open)
            backtrack(list , str+")" , open , close+1 , max);
    }
}
