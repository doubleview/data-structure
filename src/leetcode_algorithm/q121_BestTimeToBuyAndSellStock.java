package leetcode_algorithm;

/**

Say you have an array for which the ith element is the price of a given stock on day i.

        If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

        Example 1:
        Input: [7, 1, 5, 3, 6, 4]
        Output: 5

        max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
        Example 2:
        Input: [7, 6, 4, 3, 1]
        Output: 0

        In this case, no transaction is done, i.e. max profit = 0.

*/

public class q121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        q121_BestTimeToBuyAndSellStock solution = new q121_BestTimeToBuyAndSellStock();
        System.out.println(solution.maxProfit(new int[]{7 , 1 , 5 , 3 , 6 , 4}));
    }

    /**
     * ½â·¨1
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int min = prices[0];
        for(int i = 1;i<prices.length;i++) {
            maxProfit = prices[i]-min < 0 ? maxProfit : Math.max(maxProfit , prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }
}
