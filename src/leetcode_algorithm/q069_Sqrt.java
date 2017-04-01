package leetcode_algorithm;


/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * Subscribe to see which companies asked this question.
 */

public class q069_Sqrt {

    public static void main(String[] args) {
        System.out.println(new q069_Sqrt().mySqrt(4));
        System.out.println(new q069_Sqrt().mySqrt(5));
        System.out.println(new q069_Sqrt().mySqrt(100000));
    }

    /**
     *  ½â·¨1
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
