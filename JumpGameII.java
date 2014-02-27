    // see below how to optimize
    // http://blog.csdn.net/pickless/article/details/9776661

public class JumpGameII {
    public int jump(int[] A) {
        int[] dp = new int[A.length];
        for(int i = 1; i < dp.length; i++) dp[i] = -1;
        
        int range = 0;
        for(int i = 0; i < A.length; i++) {
            
            for(int j = range + 1; j <= i + A[i] && j < dp.length; j++) {
                if(dp[j] == -1) {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = dp[j] <= dp[i] + 1 ? dp[j] : dp[i] + 1;
                }
            }
            range = i + A[i];
        }
        
        return dp[dp.length - 1];
    }
}
