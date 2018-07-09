
class Solution {
    
    
    
    /*
    // back tracking , LTE
    int way = 0;
    boolean usedA = false;
    
    public int checkRecord(int n) {
        way = 0;
        usedA = false;
        
        StringBuffer sb = new StringBuffer();
        helper(n ,0, sb);
        
        return way;
    }

    private void helper(int n, int idx, StringBuffer sb) {
        if (idx == n) {
            way += 1;
            return;
        }
        
        // use P
        sb.append("P");
        helper(n, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        
        // use A
        if (!usedA) {
            usedA = true;
            sb.append("A");
            helper(n, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            usedA = false;
        }
        
        // use L
        if (sb.length() < 2 || 
            sb.charAt(sb.length() - 1) != 'L' || sb.charAt(sb.length() - 2) != 'L' ) {
            sb.append("L");
            helper(n, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    */
}



