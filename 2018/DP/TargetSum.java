


public class TargetSum {
	
	
    // dp[i][j]   first i number, sum to j
    // dp[i][j] = dp[i - 1][j - nums[i]]  or   dp[i-1][j + nums[j]]
    
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length < 1) return 0;
        
        int k = nums.length;
        int[][] dp = new int[k][2 * 1000 + 1];
        
        // initialize
        dp[0][ 1000 + nums[0] ] += 1;
        dp[0][ 1000 - nums[0] ] += 1;
        
        
        for (int i = 1; i < k; i++) {
            for (int j = 2000; j >= 0; j--) {
                if (dp[i - 1][ j ] > 0) {
                    if (j + nums[i] <= 2000) {
                        dp[i][j + nums[i]] += dp[i - 1][ j ];
                    }
                    if (j - nums[i] >= 0) {
                        dp[i][j - nums[i]] += dp[i - 1][ j ];
                    }
                }
            }
        }
        
        if (S <= 1000) {
            return dp[k - 1][1000 + S];
        } else {
            return 0;
        }
            
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TargetSum so = new TargetSum();
		
		int[] arr = { 1,1,1,1,1 };
		
		int ans = so.findTargetSumWays(arr, 3);
		
		System.out.println(ans);
	}

}


