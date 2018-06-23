
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        
        Set<Integer> set = new HashSet<Integer>();
        
        int dup = -1;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            
            if (set.contains(n)) {
                dup = n;
            } else {
                set.add(n);
            }
        }
        
        int total = (1 + nums.length) * nums.length / 2;
        
        int miss = (total - sum) + dup;
        
        ans[0] = dup;
        ans[1] = miss;
        
        return ans;
    }
}


