
// 3 sum two pointers solution 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 3) {
            return ans;
        }
        
        Arrays.sort(nums);
        
        int one = 0;
        for (one = 0; one < nums.length - 2; one++) {
            if (one > 0 && nums[one] == nums[one -1]) {
                continue;
            }
            
            int two = one + 1, three = nums.length - 1;
            while (two < three) {
                int sum = nums[one] + nums[two] + nums[three];
                
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[one], nums[two], nums[three]));
                    
                    two++;
                    while (two < three && nums[two] == nums[two - 1]) two++;
                    
                    three--;
                    while (two < three && nums[three] == nums[three + 1]) three--;
                } else if (sum < 0) {
                    two++;
                } else {
                    three--;
                }
            }
        }
        
        return ans;
    }
}

