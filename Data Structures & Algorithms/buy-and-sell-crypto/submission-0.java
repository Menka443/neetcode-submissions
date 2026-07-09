class Solution {


    public int maxProfit(int[] prices) {
        int n = prices.length;

        int maxRight = prices[n-1];
        int ans = 0;

        for(int i = n-2; i >= 0; i--){
            maxRight = Math.max(maxRight, prices[i]);
            int profit = maxRight-prices[i]; // sellingPrice-BuyingPrice
            ans = Math.max(ans, profit);
        }

          return ans;
        
    }
  
}
