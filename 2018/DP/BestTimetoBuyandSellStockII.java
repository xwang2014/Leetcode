
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        
        int profit = 0;
        int buy = prices[0];
        int last = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= last) {
                last = prices[i];
            } else {
                profit += last - buy;
                buy = prices[i];
                last = prices[i];
            }
        }
        
        if (last > buy) {
            profit += last - buy;
        }
        
        return profit;
    }


