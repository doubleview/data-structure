package leetcode_algorithm;

/**

    Implement pow(x, n).

*/

public class q050_PowXN {

    public static void main(String[] args) {
        System.out.println(new q050_PowXN().myPow(3.0, 4));
    }

    /**
     * 解法1(推荐解法)
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
