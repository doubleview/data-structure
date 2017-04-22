package leetcode_algorithm;
/**

Say you have an array for which the ith element is the price of a given stock on day i.

        Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

public class q122_BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        q122_BestTimeToBuyAndSellStock2 solution = new q122_BestTimeToBuyAndSellStock2();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * ½â·¨1
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        for(int i = 0; i<prices.length-1;i++) {
            if(prices[i+1] > prices[i]) total+=prices[i+1]-prices[i];
        }
        return total;
    }
}
