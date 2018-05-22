
class Solution {
    
    // think about such cases 
    // negative number
    // what if pivot index is 0 or (n - 1)
    
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            left[i] = (i == 0) ? nums[i] : left[i - 1] + nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = (i == nums.length - 1) ? nums[i] : right[i + 1] + nums[i];
        }
        
        for (int i = 0; i <= nums.length - 1; i++) {
            int lefty = (i == 0) ? 0 : left[i - 1];
            int righty = (i == nums.length - 1) ? 0 : right[i + 1];
            if (lefty == righty) {
                return i;
            }
        }
        return -1;
    }
}

