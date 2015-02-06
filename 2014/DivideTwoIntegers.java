// 

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        
        boolean negative = false;
        if(a < 0) {
            negative = !negative;
            a = -a;   
        }
        if(b < 0) {
            negative = !negative;
            b = -b;   
        }
        
        long ans = 0;
        while(true) {
            long tempDivisor = b;
            long tempResult = 1;
            if(tempDivisor > a) break;
            
            while( tempDivisor << 1 < a) {
                tempDivisor = tempDivisor << 1;
                tempResult = tempResult << 1;
            }
            ans += tempResult;
            a -= tempDivisor;
        }
        
        if(negative) return (int)(-ans);
        else return (int)ans;
    }

}
