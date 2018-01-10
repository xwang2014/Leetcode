

    // dp[n] = dp[k] * dp[n - k - 1]   k from 0 to n-1
    
    public int numTrees(int n) {
        if (n <= 2) return n;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = 0;
            for (int k = 0; k <= i - 1; k++) {
                dp[i] += dp[k] * dp[i - k - 1];
            }
        }
         
        return dp[n];
    }

