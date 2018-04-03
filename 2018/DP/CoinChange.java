


    // dp[i] means  fewest coin needed to make up i
    // dp[i] = dp[i - k] + cois[k]
    
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        
        Arrays.sort(coins);
        
        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                int idx = i - coins[j];
                if (idx == 0 || (idx > 0 && dp[idx] > 0) ) {
                    if (dp[i] == 0) {
                        dp[i] = dp[idx] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[idx] + 1);
                    }
                }
            }
        }
        
        return (dp[amount] == 0) ? -1 : dp[amount];
    }

