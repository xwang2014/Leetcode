
class Solution {
    
    // DP 
    // dp[target]   means number of permutations sum to target
    
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int t = 1; t <= target; t++) {
            for (int i = 1; i <= len; i++) {

                if (t - nums[i - 1] >= 0) {
                    dp[t] += dp[t - nums[i - 1]];
                }
            }
        }

        return dp[target];
    }
    
    /*
    // this is computing combinations
    public int combinationSum4(int[] nums, int target) {

        Arrays.sort(nums);
        int len = nums.length;

        int[][] dp = new int[len + 1][target + 1];
        dp[0][0] = 1;
        //for (int t = 0; t <= len; t++) dp[t][0] = 1;

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {


                if (j - nums[i - 1] >= 0) {

                    for (int k = 0; k < i; k++) {
                        dp[i][j] += dp[k][j - nums[i - 1]];
                    }

                    dp[i][j] += dp[i][j - nums[i - 1]];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= len; i++) {
            ans += dp[i][target];
        }
        return ans;
    }
    */
    
    /*
      * DFS  TLE  
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            helper(nums, target, i);
        }
        
        return res;
    }
    
    
    private void helper(int[] nums, int remain, int idx) {
        remain -= nums[idx];
        
        if (remain == 0) {
            res += 1;
            return;
        }
        if (remain < 0) {
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            helper(nums, remain, i);
        }
    }
    */
}

