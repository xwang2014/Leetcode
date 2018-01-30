


class Solution {
    public int minCostII(int[][] costs) {
        
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        
        
        for (int i = 1; i < n; i++) {
            // can store the two smallest cost of dp[i - 1] to 
            // reduce time from O(n * k * k) to O(n * k)
            for (int j = 0; j < k; j++) {
                int minPrev = Integer.MAX_VALUE;
                
                for (int t = 0; t < k; t++) {
                    if (t == j) continue;
                    
                    minPrev = Math.min(minPrev, dp[i - 1][t]);
                }
                
                dp[i][j] = costs[i][j] + minPrev;
            }
        }
        
        int cost = Integer.MAX_VALUE;
        for (int t = 0; t < k; t++) {
            cost = Math.min(cost, dp[n - 1][t]);
        }
        return cost;
    }
}

