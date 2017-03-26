package leetcode_algorithm;
/**

Reverse digits of an integer.

        Example1: x = 123, return 321
        Example2: x = -123, return -321
*/

public class q007_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(1000000003));
    }


    /**
     * 解法1
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //判断newResut是否有越界
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x/10;
        }
        return  result;
    }

}
