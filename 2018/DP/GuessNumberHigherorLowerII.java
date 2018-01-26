

    // !!! Binary search doesn't work here
    
    // [1]  no pick needed
    //  [1, 2]  pick 1  -- 1
    // [1, 2, 3] pick 2  -- 2 
    // [1, 2, 3, 4]    guess 3, then guess 1. -- 4   
    // [1, 2, 3, 4, 5]  4 + 2 -- 6
    // [1, 2, 3, 4, 5, 6]  
    
    
    // DP -- Minimax
    // refer : http://www.cnblogs.com/grandyang/p/5677550.html
    // dp[i][j] means amount needed from i to j
    // dp[i][j] = Mini  --  cost[k] + MAX ( dp[i][k - 1] ,  dp[k+1][j] )      
    
    
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        
        int[][] dp = new int[n + 1][n + 1];
        
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k <= j; k++) {
                    int local = k + Math.max( k > i ? dp[i][k - 1] : 0, k < j ? dp[k + 1][j] : 0);
                    dp[i][j] = Math.min(local, dp[i][j]);
                }
            }
        }
        
        return dp[1][n];
    }


