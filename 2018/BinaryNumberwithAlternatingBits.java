
class Solution {
    
    // solution one, check bit one by one   O(32)
    
    
    // solution two         
    /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */
    
    
    
    public boolean hasAlternatingBits(int n) {
        int b = n ^ (n >> 1);
        
        return (b & (b + 1)) == 0;
    }
}


