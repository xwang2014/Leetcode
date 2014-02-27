
public class JumpGame {
    public boolean canJump(int[] A) {
        int range = 0;
        for(int i = 0; i < A.length; i++) {
            if(range >= A.length - 1) return true;
            if(range < i) return false;
            
            int curRange = i + A[i];
            range = range >= curRange ? range : curRange;
        }
        
        if(range >= A.length - 1) return true;
        else return false;
    }
}
