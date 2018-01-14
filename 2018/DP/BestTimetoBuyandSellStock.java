
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int low = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= low) {
                low = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - low);
            }
        }
        
        return profit;
    }



