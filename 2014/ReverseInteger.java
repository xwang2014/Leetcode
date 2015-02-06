
public class ReverseInteger {
    // negative -123
    // trailing zero  1350 
    //  overflow  
    public int reverse(int x) {
       
        boolean negative = false;
        if(x < 0) {
            negative = true;
            if(x == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else x = -x;
        }
        
        int result = 0;
        while(x > 0) {
            int digit = x % 10;
            x = x / 10;
            
            if( (Integer.MAX_VALUE - digit) / 10 >= result) {
                result = result * 10 + digit;
            } else {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        return negative ? -result : result;
    }

}

