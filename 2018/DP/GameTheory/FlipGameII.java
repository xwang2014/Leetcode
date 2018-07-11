
class Solution {
    
    /**
    // back tracking and memorization
    // time O(N!)
    public boolean canWin(String s) {
        Map<String, Boolean> winMap = new HashMap<String, Boolean>();
        winMap.put(null, false);
        winMap.put("", false);
        winMap.put("+", false);
        winMap.put("++", true);
        winMap.put("+++", true);
        
        return firstWin(s, winMap);
    }
    
    private boolean firstWin(String s, Map<String, Boolean> winMap) {
        if (winMap.containsKey(s)) {
            return winMap.get(s);
        }
        
        int idx = 0;
        while ( (idx = s.indexOf("++", idx)) != -1 ) {
            char[] arr = s.toCharArray();
            arr[idx] = '-';
            arr[idx + 1] = '-';
            
            if ( !firstWin(new String(arr), winMap)) {
                winMap.put(s, true);
                return true;
            }
            
            idx = idx + 1;
        }
        
        winMap.put(s, false);
        return false;
    }
    */
}


