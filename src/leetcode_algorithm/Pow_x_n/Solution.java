package leetcode_algorithm.Pow_x_n;

/**

    Implement pow(x, n).

*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(3.0 , 4));
    }

    /**
     * ÍÆ¼ö½â·¨
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n ==0 )
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if(Double.isInfinite(x))
            return 0;
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}
