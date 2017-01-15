package algorithm.Divide_Two_Integers;


/**

Divide two integers without using multiplication, division and mod operator.

        If it is overflow, return MAX_INT.

*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().divide(20 , 2));
    }

    /**
     * ÍÆ¼ö½â·¨
     * @param dividend
     * @param divisor
     * @return
     */
    public  int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if(ldivisor == 0) return Integer.MAX_VALUE;
        if(ldividend ==0 || (ldividend < ldivisor)) return 0;
        long lans = ldivide(ldividend, ldivisor);

        int ans ;
        if (lans > Integer.MAX_VALUE) {
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum+=sum;
            multiple +=multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

}
