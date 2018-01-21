
    // O(n) is easy
    // O(log n) binary search like
    
    public int findPeakElement(int[] nums) {
        
        if (nums == null || nums.length <= 1) return 0;
        
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[left] > nums[right]) return left;
        else return right;
        
    }


