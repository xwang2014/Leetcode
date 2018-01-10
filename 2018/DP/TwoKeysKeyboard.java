

    public int minSteps(int n) {
        // dp[i] means min step needed to get i A
        // dp[i] = dp[ k ] + (i - k) / k + 1  if  i%k==0  
        
        if (n <= 1) return 0;
        
        int[] dp = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i / 2; j >= 1; j--) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) / j + 1);
                }
            }
        }
        
        return dp[n];
    }

