// Newton's iteration
// http://gongxuns.blogspot.com/2012/12/leetcode-sqrtx.html



public class Sqrt {
    public int sqrt(int x) {
        if(x == 0) return 0;
        if(x <= 2) return 1;
        
        double i = x / 2;
        while( Math.abs(i * i - x) > 0.0001) {
            i = (i + x / i) / 2;
        }
        
        return (int)i;
    }

}
