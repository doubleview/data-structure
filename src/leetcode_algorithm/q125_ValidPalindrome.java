package leetcode_algorithm;

/**

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

        For example,
        "A man, a plan, a canal: Panama" is a palindrome.
        "race a car" is not a palindrome.

*/

public class q125_ValidPalindrome {

    public static void main(String[] args) {
        q125_ValidPalindrome solution = new q125_ValidPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }

    /**
     * 解法1 (个人解法)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int start = -1;
        int end = s.length();
        char[] strs = s.toCharArray();
        do{
            do {start++;}while (start<s.length() && !Character.isLetterOrDigit(strs[start]));
            do {end--;}while (end>-1 && !Character.isLetterOrDigit(strs[end]));
        }while (start<=end && Character.toLowerCase(strs[start]) == Character.toLowerCase(strs[end]));
        if(start>end) return true;
        return false;
    }


    /**
     * 解法2
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "");
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

}
