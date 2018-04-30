

class Solution {
    
    // https://blog.csdn.net/MebiuW/article/details/53266731
    
    // refer : http://www.cnblogs.com/EdwardLiu/p/6168469.html
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        
        if ( (1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        
        char[] state = new char[maxChoosableInteger + 1];
        for (int i = 0; i < state.length; i++) {
            state[i] = '0';
        }
        
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        
        return dfs(desiredTotal, state, map);
    }
    
    private boolean dfs(int total, char[] state, Map<String, Boolean> map) {
        
        String curState = new String(state);
        if (map.containsKey(curState)) {
            return map.get(curState);
        }
        
        for (int i = 1; i < state.length; i++) {
            if (state[i] == '0') {
                state[i] = '1';
                if (total <= i || !dfs(total - i, state, map)) {
                    map.put(curState, true);
                    state[i] = '0';
                    return true;
                } else {
                    state[i] = '0';
                }                
            }
        }
        
        map.put(curState, false);
        return map.get(curState);
    }
    
    
}


