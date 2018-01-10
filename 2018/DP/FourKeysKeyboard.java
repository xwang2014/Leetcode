
    // refer : http://www.cnblogs.com/grandyang/p/7448390.html
    
    // dp[i] = dp[i - 1] + 1  OR
    // dp[i] = dp[i - (x + 1)] * x 
    
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;
        
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            
            for (int x = 1; x < i - 1; x++) {
                dp[i] = Math.max(dp[i],  dp[i - (x + 1)] * x);
            }
        }
        
        return dp[N];
    }



