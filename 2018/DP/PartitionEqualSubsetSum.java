

public class PartitionEqualSubsetSum {
	
	
	
    // max array size 200
    // max num 100
    // max sum 200 * 100 = 20000
    
    public boolean canPartition(int[] nums) {
        
        if (nums == null || nums.length == 0) return true;
        
        boolean[] dp = new boolean[200 * 100 + 1];
        dp[0] = true;
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            for (int j = Math.min(20000, 200 * i); j >= 0; j--) {
                if (dp[j] && j + nums[i] < dp.length) {
                    dp[j + nums[i]] = true;
                }
            }
        }
        
        if (sum % 2 != 0) return false;
        else {
            return dp[sum / 2];
        }
        
    }	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionEqualSubsetSum so = new PartitionEqualSubsetSum();
		
		int[] nums = {1, 2, 5};
		boolean flag = so.canPartition(nums);
		System.out.println(flag);
	}

}



