
class Solution {
    
    // the hamming distance on a digit is numberOfZero * numberOfOne
    
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        
        int n = nums.length;
        int[] digit = new int[32];
        
        for (int i = 0; i < nums.length; i++) {
            process(digit, nums[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < digit.length; i++) {
            ans += digit[i] * (n - digit[i]);
        }
        
        return ans;
    }
    
    private void process(int[] digit, int number) {
        int mask = 1;
        
        for (int i = 0; i < 32; i++) {
            int temp = number & (mask << i);
            if (temp != 0) {
                digit[i] += 1;
            }
        }
    }
}

