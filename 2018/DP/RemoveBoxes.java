class Solution {
    
    // similar problem : Zuma Game, Burst Balloon, Strange Printer
    // refer : http://www.cnblogs.com/grandyang/p/6850657.html
    
    
    // dp[i][j][k] means max value from boxes [i, j] and attached k boxes with the same colar as box[i]
    // dp[i][j][k] = (k + 1) * (k + 1) + dp[i + 1][j][0]     -- case 1 only remove box[i] and attached
    //               dp[i + 1][m - 1][0] + dp[m][j][k + 1]   -- case 2 if box[m] = box[i]
    
    
    
    // dp[i][i][0] = (0 + 1) * (0 + 1) = 1;
    // final goal is dp[0][n - 1][0]
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length < 1) return 0;
        int n = boxes.length;
        
        int[][][] dp = new int[n][n][n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k <= j; k++) {
                dp[j][j][k] = (k + 1) * (k + 1);
            }
        }
        
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = Math.min(i + len - 1, n - 1);
                
                for (int k = 0; k <= i; k++) {
                    int res = (k + 1) * (k + 1) + (( i + 1 <= j ) ? dp[i + 1][j][0] : 0);
                    
                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] != boxes[i]) continue;
                        
                        int val = ( (i + 1 <= m - 1) ? dp[i + 1][m - 1][0] : 0 )
                            + dp[m][j][k + 1];
                        
                        res = Math.max(val, res);
                    }
                    
                    dp[i][j][k] = res;
                }   
            }
        }
        
        return dp[0][n - 1][0];
    }
}



