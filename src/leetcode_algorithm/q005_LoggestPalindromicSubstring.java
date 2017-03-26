package leetcode_algorithm;

/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

        Example:

        Input: "babad"

        Output: "bab"

        Note: "aba" is also a valid answer.


        Example:

        Input: "cbbd"

        Output: "bb"
*/

public class q005_LoggestPalindromicSubstring {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbc"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("abcda"));
    }

    /**
     * 解法1
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int max = 1;
        String str = s.length() > 0 ? s.substring(0 , 1) : "";
        for(int i = 1;i < s.length();i ++){
            for(int j = 0;j< i; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    StringBuilder temp = new StringBuilder(s.substring(j , i+1));
                    if(temp.toString().equals(temp.reverse().toString())){
                        if(i - j +1 > max){
                            max = i - j + 1;
                            str = temp.toString();
                        }
                        break;
                    }
                }
            }
        }
        return  str;
    }


    /**
     * 解法2
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private int lo, maxLen;
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

}
