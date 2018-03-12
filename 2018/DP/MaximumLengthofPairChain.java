

    //  firstly sort. secondly check previous pairs   O(n^2)
    
    public int findLongestChain(int[][] pairs) {
        
        if (pairs == null || pairs.length == 0) return 0;
        
        Arrays.sort(pairs, (p1, p2) -> (p1[0] - p2[0]) );
        
        int[] dp = new int[pairs.length];
        
        dp[0] = 1;
        
        for (int i = 1; i < pairs.length; i++) {
            int curLen = 1;
            int curEnd = pairs[i][1];
            
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[j][1] < pairs[i][0] && dp[j] >= curLen) {
                    curLen = dp[j] + 1;
                }
            }
            dp[i] = curLen;
        }
        
        return dp[pairs.length - 1];
    }


