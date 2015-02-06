
public class InterleavingString {
    // http://fisherlei.blogspot.com/2012/12/leetcode-interleaving-string.html
    // DP
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                dp[i][j] = ( dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)) )
                    || ( dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)) );
            }
        }
        
        return dp[s1.length()][s2.length()];
    }


/*
* DFS Time Limit Exceeded ---

    private boolean flag = false;
    public void dfs(String s1, String s2, String s3) {
        if(flag) return;
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            flag = true;
            return;
        }
        
        Character c1 = null, c2 = null, c3 = s3.charAt(0);
        if(s1.length() > 0)  {
            c1 = s1.charAt(0);
            if(c1 == c3) dfs(s1.substring(1), s2, s3.substring(1));
        }
        if(s2.length() > 0) {
            c2 = s2.charAt(0);
            if(c2 == c3) dfs(s1, s2.substring(1), s3.substring(1));
        }
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        
        flag = false;
        dfs(s1, s2, s3);
        return flag;
    }
*/
}
