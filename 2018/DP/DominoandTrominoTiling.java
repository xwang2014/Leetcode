
class Solution {
    // refer : http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-790-domino-and-tromino-tiling/
    public int numTilings(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 5;
        
        int[][] dp = new int[N + 1][3];
        
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;
        dp[2][2] = 1;
            
        int mod = 1000000007;
        for (int i = 3; i <= N; i++) {
            dp[i][0] = ( ( dp[i - 1][0] + dp[i - 2][0] ) % mod + ( dp[i - 1][1] + dp[i - 1][2] ) % mod ) % mod;
            dp[i][1] = (dp[i - 1][2] + dp[i - 2][0] ) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 2][0] ) % mod;
        }
        
        return dp[N][0] % mod;
    }
}


