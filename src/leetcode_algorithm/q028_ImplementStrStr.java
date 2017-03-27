package leetcode_algorithm;


/**
 *
    Implement strStr().

        Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/

public class q028_ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr2("sdrvseew143" , "rv"));
    }

    /**
     * 解法1 个人解法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    /**
     * 解法2 推荐解法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        for(int i = 0 ;;i++) {
            for(int j = 0;;j++) {
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                if(needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
