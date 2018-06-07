class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        // key prefix sum,  value first index
        Map<Integer, Integer> prefix = new HashMap<Integer, Integer>();
        
        prefix.put(0, 0); // intial case. Important
        
        int sum = 0;
        int maxSub = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int rest = sum - k;
            
            if (prefix.containsKey(rest)) {
                int len = i - prefix.get(rest) + 1;
                maxSub = Math.max(maxSub, len);
            }
            
            if (!prefix.containsKey(sum)) {
                prefix.put(sum, i + 1);
            }
        }
        
        return maxSub;
    }
}

