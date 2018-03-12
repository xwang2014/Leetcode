

    // dp[i][j] -- max string num from i 0 and j 1
    // for str s    dp[i][j] = dp[i - k][j - t] + 1
    //                           dp[i - 1][j - 1]
    //                           dp[i][j - 1]
    //                           dp[i - 1][j]
    
    
    // Time O(s * m * n)   Space can optimize
    
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null) return 0;
        
        int[][] dp = new int[m + 1][n + 1];
        
        // compute zero and one 
        
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int zero = 0, one = 0;
            for (int t = 0; t < s.length(); t++) {
                if (s.charAt(t) == '0') zero++;
                else one++;
            }
            
            
            for (int a = m; a >= 0; a--) {  // inner pointers from right to left
                for (int b = n; b >= 0; b--) {  
                    
                    if (a - zero >= 0 && b - one >= 0) {
                        dp[a][b] = Math.max(dp[a][b], dp[a - zero][b - one] + 1);
                    }
                    
                    if (a > 0) dp[a][b] = Math.max(dp[a][b],dp[a - 1][b]);
                    if (b > 0) dp[a][b] = Math.max(dp[a][b],dp[a][b - 1]);
                }
            }
        }
        
        return dp[m][n];
    }


