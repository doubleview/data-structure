package leetcode_algorithm;

/**


Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

        For example,
        Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


*/

public class q042_TrapingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new q042_TrapingRainWater().trap(height));
    }


    /**
     * 解法1 (推荐解法)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int a = 0;
        int b = height.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(a<=b){
            leftmax = Math.max(leftmax, height[a]);
            rightmax = Math.max(rightmax, height[b]);
            if (leftmax < rightmax) {
                max += (leftmax - height[a]);
                a++;
            }else {
                max += (rightmax - height[b]);
                b--;
            }
        }
        return max;
    }


}
