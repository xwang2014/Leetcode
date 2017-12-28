
    // refer : https://leetcode.com/problems/maximum-product-subarray/discuss/48230/
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        
        int max = nums[0], min = nums[0], cur = nums[0];
        
        int i = 1;
        while (i < nums.length) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            
            cur = Math.max(max, cur);
            i++;
        }
        
        return cur;
    }


