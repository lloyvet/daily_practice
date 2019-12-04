package Leetcode;

public class Gupiao {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = 0;
       for (int i = 0; i < prices.length - 1; i++){
           for(int j = i + 1; j < prices.length; j++){
               int profit = prices[j]-prices[i];
               if(maxProfit<profit)
                   maxProfit = profit;
           }
       }
       System.out.println(maxProfit);
    }
}
