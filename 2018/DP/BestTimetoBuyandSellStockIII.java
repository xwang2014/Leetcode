

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int maxProfit = 0;
        int buy = prices[0];
        
        int[] leftProfit = new int[prices.length];
        for (int i = 1; i < leftProfit.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            }
            leftProfit[i] = maxProfit;
        }
        
        maxProfit = 0;
        int sell = prices[prices.length - 1];
        int[] rightProfit = new int[prices.length];
        for (int j = prices.length - 2; j >= 0; j--) {
            if (prices[j] > sell) {
                sell = prices[j];
            } else {
                maxProfit = Math.max(maxProfit, sell - prices[j]);
            }
            rightProfit[j] = maxProfit;
        }
        
        int twoTran = 0;
        for (int i = 1; i < prices.length; i++) {
            twoTran = Math.max(twoTran, leftProfit[i - 1] + rightProfit[i]);
        }
        
        return Math.max(twoTran, rightProfit[0]);
    }


