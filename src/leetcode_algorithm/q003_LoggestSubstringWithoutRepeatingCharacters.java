package leetcode_algorithm;

import java.util.HashSet;
import java.util.Set;

/**
Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class q003_LoggestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(solution1("abcabcbb"));
        System.out.println(solution1("bbbbbbbb"));
        System.out.println(solution1("pwwkew"));
        System.out.println(solution1("abba"));
        System.out.println(solution1(""));

        System.out.println(solution2("abcabcbb"));
        System.out.println(solution2("bbbbbbbb"));
        System.out.println(solution2("pwwkew"));
        System.out.println(solution2("abba"));
        System.out.println(solution2(""));
    }

    /**
     * 解法1
     * @param s
     * @return
     */
    public static int solution1(String s){
        if(s == null && s.length() == 0){
            return 0;
        }
        int first = 0;
        int repeat = 1;
        for(int i = 1; i<s.length();i++){
            boolean repeatable  = false;
            for(int j = first;j < i;j++){
                if(s.charAt(i) == s.charAt(j)){
                    repeatable = true;
                    if(i- first > repeat){
                        repeat =i - first;
                    }
                    first = j + 1;
                    break;
                }
            }
            if(!repeatable && i - first + 1 > repeat){
                repeat = i - first + 1;
            }
        }
        return  repeat;
    }


    /**
     * 解法2
     *
     * @param s
     * @return
     */
    public static int solution2(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0;i< n ;i++){
            for(int j = i+1;j<=n;j++){
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans , j - i);
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s , int start , int end){
        Set<Character> set = new HashSet<>();
        for(int i = start;i<end;i++){
            Character ch = s.charAt(i);
            if(set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


}
