package leetcode_algorithm;

import java.util.Arrays;

/**

There are N children standing in a line. Each child is assigned a rating value.

        You are giving candies to these children subjected to the following requirements:

        Each child must have at least one candy.
        Children with a higher rating get more candies than their neighbors.
        What is the minimum candies you must give?
*/

public class q135_Candy {

    public static void main(String[] args) {
        q135_Candy solution = new q135_Candy();
        System.out.println(solution.candy(new int[]{1 , 2 , 3 , 6 ,3 , 2}));
    }

    /**
     * ½â·¨1
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies , 1);
        for(int i = 1;i<candies.length;i++) {
            if(ratings[i] > ratings[i-1]) candies[i] = (candies[i - 1] + 1);
        }
        for(int i = candies.length-2;i>=0;i--) {
            if (ratings[i]>ratings[i+1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        int sum = 0;
        for(int candy : candies)
            sum+=candy;
        return sum;
    }
}
