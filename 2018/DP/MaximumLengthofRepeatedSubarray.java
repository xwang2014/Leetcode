

    // refer : http://www.cnblogs.com/grandyang/p/7801533.html
    //  dp[i][j] means common substring A[:i] B[:j]  ending in index i and j
    //  dp[i][j] = dp[i - 1][j - 1] + 1   if A[i] == B[j]
    //           =  0   elsewise
    
    public int findLength(int[] A, int[] B) {
        
        int[][] dp = new int[A.length][B.length];
        
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = 1 + ( (i > 0 && j > 0) ? dp[i - 1][j - 1] : 0 );
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }


