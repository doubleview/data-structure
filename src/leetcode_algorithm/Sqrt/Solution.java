package leetcode_algorithm.Sqrt;


/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * Subscribe to see which companies asked this question.
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(4));
        System.out.println(new Solution().mySqrt(5));
        System.out.println(new Solution().mySqrt(100000));
    }

    /**
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
