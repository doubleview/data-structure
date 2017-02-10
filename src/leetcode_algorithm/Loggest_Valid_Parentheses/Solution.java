package leetcode_algorithm.Loggest_Valid_Parentheses;


import java.util.Stack;

public class Solution {

    /**
        Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

        For "(()", the longest valid parentheses substring is "()", which has length = 2.

        Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

    */

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses(")()())()()()"));
        System.out.println(new Solution().longestValidParentheses("()(()(()()"));
        System.out.println(new Solution().longestValidParentheses("()(()(()()))"));
    }


    /**
     * ÍÆ¼ö½â·¨
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for(int j = 0; j<s.length();j++) {
            if(s.charAt(j) == '(') stack.push(j);
            else {
                if(stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if(stack.isEmpty()) max = Math.max(max, j - left);
                     else max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
    }


    /**
         * And the DP idea is :

         If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.

         Else if s[i] is ')'

         If s[i-1] is '(', longest[i] = longest[i-2] + 2

         Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]

         For example, input "()(())", at i = 5, longest array is [0,2,0,0,2,0], longest[5] = longest[4] + 2 + longest[1] = 6.
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        s = ")" + s;
        int[] longest = new int[s.length() + 1];

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')' && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] = longest[i - 1] + 2 + longest[i - longest[i - 1] - 2];
                longest[s.length()] = Math.max(longest[i], longest[s.length()]);
            }
        }

        return longest[s.length()];
    }


}
