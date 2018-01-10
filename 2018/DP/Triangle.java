

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        int k = triangle.size();
        int[] dp = new int[k];
        dp[0] = triangle.get(0).get(0);
        
        for(int i = 1; i < k; i++) {
            for(int j = i; j >= 0; j--) {
                if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }
        
        int min = dp[0];
        for (int i = 1; i < k; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

