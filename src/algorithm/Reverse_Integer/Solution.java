package algorithm.Reverse_Integer;
/**

Reverse digits of an integer.

        Example1: x = 123, return 321
        Example2: x = -123, return -321
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(1000000003));
    }

    /**
     * 个人解法
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String s  = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        if(x < 0){
            sb.insert(0 , "-");
        }
        try {
            Integer i = Integer.parseInt(sb.toString());
            return i;
        }catch (NumberFormatException e){
            return 0;
        }
    }


    public static int reverse2(int x) {
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
