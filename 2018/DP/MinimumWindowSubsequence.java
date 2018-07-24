







/**

class Solution {
    
    // memory limit exceeded
    // f[i][j][k]   
    // f[i][j][k] =  if S[j] == T[k]   f[i][j - 1][k - 1] + 1
    //              max f[i][j - 1][k - 1] f[i][j - 1][k]  f[i][j][k - 1]
    
    public String minWindow(String S, String T) {
        
        int s = S.length(), t = T.length();
        
        int[][][] f = new int[s][s][t];
        
        for (int i = s - 1; i >= 0; i--) {
            for (int j = i; j < s; j++) {
                
                for (int k = 0; k < t && k <= (j - i); k++) {
                    if (S.charAt(j) == T.charAt(k)) {
                        f[i][j][k] = (i <= j - 1 && k > 0) ? f[i][j - 1][k - 1] + 1 : 1;
                    } else {
                        f[i][j][k] = Math.max(
                                Math.max(
                                j >= 1 && k >= 1 ? f[i][j - 1][k - 1] : 0,
                                j >= 1 ? f[i][j - 1][k] : 0),
                                k >= 1 ? f[i][j][k - 1] : 0
                                );
                    }
                    
                }
            }
        }
        
        String ans = "";
        int len = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for (start = 0; start < s; start++) {
            for (end = start; end < s; end++) {
                if (f[start][end][t - 1] == t && end - start < len) {
                    len = end - start;
                    ans = S.substring(start, end + 1);
                }
            }
        }
        
        return ans;
    }
}



*/

