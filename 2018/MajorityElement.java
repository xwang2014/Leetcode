

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        
        int maj = nums[0], time = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (time == 0) {
                maj = nums[i];
                time = 1;
            } else {
                if (maj == nums[i]) {
                    time++;
                } else {
                    time--;
                }
            }
        }
        
        return maj;
    }



