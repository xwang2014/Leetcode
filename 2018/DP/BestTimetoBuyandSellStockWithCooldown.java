

    // https://soulmachine.gitbooks.io/algorithm-essentials/java/dp/best-time-to-buy-and-sell-stock-with-cooldown.html
    
    // sell[i] -- max profit from fist i days. last action is sell.
    // buy[i] -- max profit from first i days. last action is buy
    
    // sell[i] = { sell[i - 1], buy[i - 1] + price }
    // buy[i] = { buy[i - 1], sell[i - 2] - price }
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int len = prices.length;
        int[] sell = new int[len];
        int[] buy = new int[len];
        
        sell[0] = 0;
        buy[0] = -prices[0];
        
        for (int i = 1; i < len; i++) {

            buy[i] = Math.max(
                        buy[i - 1],
                        (i >= 2 ? sell[i - 2] : 0) - prices[i]
                        );
            sell[i] = Math.max(
                        sell[i - 1] ,
                        buy[i - 1] + prices[i]
                        );
        }
        
        return sell[len - 1]; 
    }


