package Array;

public class MaxProfit {
    public static  int maxProfit(int[] prices) {
        int lowestPrice = prices[0], maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            if(lowestPrice > prices[i]){
                lowestPrice = prices[i];
            }

            int profit = prices[i] - lowestPrice;

            if(profit > maxProfit){
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args){
        // int[] prices = {7,1,5,3,6,4};
        // Output: 5
        
        int[] prices = {7,6,4,3,1};
        // Output: 0
        int ans = maxProfit(prices);

        System.out.println(ans);
    }
}
