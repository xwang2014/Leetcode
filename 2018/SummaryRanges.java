class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        
        if (nums == null || nums.length < 1) {
            return ans;
        }
        
        int start = 0, end = 0;
        while (end < nums.length - 1) {
            if (nums[end] + 1 == nums[end + 1]) {
                end += 1;
            } else {
                
                String temp = process(nums, start, end);
                ans.add(temp);
                
                start = end + 1;
                end = end + 1;
            }
        }
        String temp = process(nums, start, end);
        ans.add(temp);
            
        return ans;
    }
    
    private String process(int[] nums, int start, int end) {
        if (start == end) {
            return "" + nums[start];
        } else {
            return nums[start] + "->" + nums[end];
        }
    }
}
