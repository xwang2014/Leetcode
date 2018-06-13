
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        
        // key sum[0,i]
        // value number of i
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int rest = sum - k;
            if (map.containsKey(rest)) {
                ans += map.get(rest);
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        
        return ans;
    }
}

