

    // refer : http://massivealgorithms.blogspot.com/2017/01/leetcode-486-predict-winner.html
    // http://storypku.com/2017/11/leetcode-question-486-predict-the-winner/
    
    
    // f[i][j] = nums[i] + MIN(f[i + 2][j], f[i+1][j-1])       or       nums[j] + MIN(f[i+1][j-1], f[i][j-2])   
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length < 1) return false;
        
        int n = nums.length;
        int sum = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }
        
        
        for (int j = 0; j < n; j++) {
            
            for (int i = j - 1; i >= 0; i--) {
                int a = (i + 1 >= 0 && j - 1 < n) ? dp[i + 1][j - 1] : 0;
                int b = (i + 2 >= 0 && i + 2 <= j) ? dp[i + 2][j] : 0 ;
                int c = (j - 2 < n && i <= j - 2) ? dp[i][j - 2] : 0 ;
                
                dp[i][j] = Math.max(
                            nums[i] + Math.min(a, b),
                            nums[j] + Math.min(a, c)
                            );
                
            }
        }
        
        return dp[0][n - 1] * 2 >= sum;
    }

