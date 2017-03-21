package leetcode_algorithm;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */

public class q084_LargestRectangleInHistogram {

    public static void main(String[] args) {
        q084_LargestRectangleInHistogram solution = new q084_LargestRectangleInHistogram();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(solution.largestRectangleArea(new int[]{2, 4, 6, 8, 2, 3}));
        System.out.println(solution.largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
        System.out.println(solution.largestRectangleArea(new int[]{6, 3, 5, 4, 5, 1, 6}));
    }

    /**
     * ¿˚”√’ª
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len) ? 0 : heights[i];
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

}
