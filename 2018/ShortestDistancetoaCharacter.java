
class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            
            if (cur == C) {
                ans[i] = 0;
                
                // left
                for (int left = i - 1; left >= 0; left--) {
                    if (S.charAt(left) == C) break;
                    
                    if (ans[left] == 0 || ans[left] > i - left) {
                        ans[left] = i - left;
                    } else {
                        break;
                    }
                }
                
                // right
                for (int right = i + 1; right < ans.length; right++) {
                    if (S.charAt(right) == C) break;
                    
                    if (ans[right] == 0 || ans[right] > right - i) {
                        ans[right] = right - i;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}

