package leetcode_algorithm;

import java.util.ArrayList;
import java.util.List;

/**

Given a string s, partition s such that every substring of the partition is a palindrome.

        Return all possible palindrome partitioning of s.

        For example, given s = "aab",
        Return

        [
        ["aa","b"],
        ["a","a","b"]
        ]

*/

public class q131_PalindromePatitioning {

    public static void main(String[] args) {
        q131_PalindromePatitioning solution = new q131_PalindromePatitioning();
        System.out.println(solution.partition("aab"));
    }

    List<List<String>> resultList;
    ArrayList<String> currList;

    /**
     * ½â·¨1
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        resultList = new ArrayList<>();
        currList = new ArrayList<>();
        backTrack(s,0);
        return resultList;
    }

    private void backTrack(String s, int l) {
        if (currList.size() > 0 && l >= s.length()) {
            List<String> r = (ArrayList)currList.clone();
            resultList.add(r);
        }
        for(int i = l;i<s.length();i++) {
            if (isPalindrome(s, l, i)) {
                if(l == i)
                    currList.add(Character.toString(s.charAt(i)));
                else
                    currList.add(s.substring(l, i + 1));
                backTrack(s , i+1);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if(l == r) return true;
        while (l < r) {
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
