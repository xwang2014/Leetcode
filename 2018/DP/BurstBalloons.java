
class Solution {
    
    // similar problem : Zuma Game, Remove Boxes, Strange Printer
    // refer : http://www.cnblogs.com/grandyang/p/5006441.html
    // video explain https://www.youtube.com/watch?v=IFNibRVgFBo
    
    
    // dp[i][j] mean max value from bursting balloon [i, j] while [0, i - 1] [j + 1, n - 1] are not burst
    // dp[i][j] = max { dp[i][j],  dp[i][k - 1] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j + 1]} 
    //    k is the last balloon bursted in [i, j]
    
    
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        
        int n = nums.length;
        
        int[][] dp = new int[n][n];
        
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = Math.min(i + len - 1, n - 1);
             
                int maxVal = 0;
                for (int k = i; k <= j; k++) {
                    int val = ( (k - 1 >= i) ? dp[i][k - 1] : 0)
                        + ( (k + 1 <= j) ? dp[k + 1][j] : 0)
                        + ((i - 1 >= 0) ? nums[i - 1] : 1) * nums[k] * ( (j + 1 < n) ? nums[j + 1] : 1);
                    maxVal = Math.max(maxVal, val);
                }
                
                dp[i][j] = Math.max(dp[i][j], maxVal);
            }
        }
        
        return dp[0][n - 1];
    }
}


