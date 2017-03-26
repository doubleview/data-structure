package leetcode_algorithm;


public class q009_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1233221));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(-123321));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-10));
    }

    /**
     * ½â·¨1
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        if(x/10 == 0)
            return true;
        int[] temp = new int[String.valueOf(x).length()];
        int i = 0;
        while (x != 0) {
            temp[i++] = x % 10;
            x = x / 10;
        }
        for( i = 0;i<temp.length;i++) {
            if(temp[i] != temp[temp.length - i - 1])
                return false;
        }
        return true;
    }


}
