
    // refer : http://www.cnblogs.com/grandyang/p/7776979.html
    
    // buy[i] -- max profit from first i days. Last transaction is buy
    // sell[i] -- max profit from first i days. Last transaction is sell
    
    // buy[i] = { buy[i - 1],   sell[i - 1] - prices[i] }
    // sell[i] = { sell[i - 1], buy[i - 1] + prices[i] - fee }
    
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max (buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max (sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        
        return sell[len - 1];
    }


