




    // refer : https://aaronice.gitbooks.io/lintcode/content/high_frequency/best_time_to_buy_and_sell_stock_iv.html

    // local[i][k] -- k transactions. Last sell on day i
    // global[i][k] -- k transactions during day i
    
    // global[i][k] = max (local[i][k], global[i - 1][k])
    // local[i][k] = max (  global[i - 1][k - 1] + max(diff, 0),    local[i - 1][k] + diff   )
        
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices == null || prices.length < 2) return 0;
        
        if (prices.length <= k * 2) {
            return unlimitedTransaction(k, prices);
        }
        
        int[][] local = new int[prices.length][k + 1];
        int[][] global = new int[prices.length][k + 1];
        
        for (int kk = 1; kk <= k; kk++) {
            
            for (int i = 1; i < prices.length; i++) {
                local[i][kk] = Math.max(
                                local[i - 1][kk] + (prices[i] - prices[i - 1]),
                                global[i - 1][kk - 1] + Math.max(0, prices[i] - prices[i - 1])
                                );
                global[i][kk] = Math.max(
                                local[i][kk],
                                global[i - 1][kk]
                                );
            }
        }
        
        return global[prices.length - 1][k];
    }
    
    public int unlimitedTransaction(int k, int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= buy) {
                maxProfit += prices[i] - buy;
            }
            buy = prices[i];
        }
        
        return maxProfit;
    }



/*

LTE  time complecity O(n ^ 3) 

    // refer : http://www.cnblogs.com/grandyang/p/4295761.html
    // dp[i][k] = dp[i - x][k - 1] + maxProfitFrom[x + 1, i]
    
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 2 || k < 1) return 0;
        
        int len = prices.length;
        int[][] profitChart = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            int low = prices[i];
            int maxProfit = 0;
            
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= low) {
                    low = prices[j];
                } else {
                    maxProfit = Math.max(maxProfit, prices[j] - low);
                }
                profitChart[i][j] = maxProfit;
            }
        }
        
        int[][] dp = new int[len][k + 1];
        for (int i = 0; i < len; i++) {
            dp[i][1] = profitChart[0][i];
        }
        
        for (int j = 2; j <= k; j++) {
            for (int i = 1; i < len; i++) {
                
            	for (int t = 0; t < i; t++) {
            		dp[i][j] = Math.max(
            				dp[t][j - 1] + profitChart[t + 1][i],
            				dp[i][j]
            				);
            	}
            	
            }
        }
        
        int maxProfit = 0;
        for (int i = 1; i <= k; i++) {
            maxProfit = Math.max(maxProfit, dp[len - 1][i]);
        }
        
        return maxProfit;
    }

*/

