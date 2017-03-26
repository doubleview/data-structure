package leetcode_algorithm;


/**
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class q014_LoggestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a" , "a" , "b"}));
        System.out.println(longestCommonPrefix(new String[]{"abca", "abc"}));
        System.out.println(longestCommonPrefix(new String[]{"ac", "ac", "a", "a"}));
    }

    /**
     * 解法1(个人解法)
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i< strs[0].length();i++) {
            char c = strs[0].charAt(i);
            for(int j = 1 ; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 解法2
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }


}
