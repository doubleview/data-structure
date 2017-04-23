package leetcode_algorithm;
/**

Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete at most two transactions.

*/

public class q123_BestTimeToBuyAndSellStock3 {

    public static void main(String[] args) {
        q123_BestTimeToBuyAndSellStock3 solution = new q123_BestTimeToBuyAndSellStock3();
        System.out.println(solution.maxProfit(new int[]{7 , 1 , 5 , 3 , 6 , 4}));
    }

    /**
     * ½â·¨1
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE , hold2 = Integer.MIN_VALUE;
        int release1 = 0 , release2 = 0;
        for (int i : prices) {
            release2 = Math.max(release2, hold2 + i);
            hold2 = Math.max(hold2 , release1-i);
            release1 = Math.max(release1, hold1 + i);
            hold1 = Math.max(hold1, -i);
        }
        return release2;
    }

}
