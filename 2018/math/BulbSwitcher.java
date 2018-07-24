
class Solution {
    
    // a bulb n will be toggled k times. k is the number of factors of n
    // as we know, factors come into pairs   n = 1 * n, 2 * n/2 if n is even
    // if n is a squre number, the k is odd. Otherwise, k is even
    // the squre number equal or less than n == squrt root of n
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    
    
    /*
    public int bulbSwitch(int n) {
        int ans = 0;
        for (int t = 1; t <= n; t++) {
            if (factor(t) % 2 == 1) {
                ans += 1;
            }
        }
        return ans;
    }
    
    // get number of factors of n
    private int factor(int n) {
        int res = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                res += 1;
            }
        }
        
        return res;
    }
    */
}


