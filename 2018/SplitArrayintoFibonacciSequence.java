
class Solution {
    
    // backtracking -- DFS
    
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<Integer>();
        
        helper(S, 0, res);
        
        return res;
    }
    
    private boolean helper(String s, int idx, List<Integer> res) {
        if (idx == s.length() && res.size() >= 3) {
            return true;
        }
        
        for (int pt = idx; pt < s.length(); pt++) {
            // leading zero
            if (pt > idx && s.charAt(idx) == '0') {
                break;
            }
            
            long num = Long.parseLong(s.substring(idx, pt + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            
            int size = res.size();
            // early termination
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size < 2 || (res.get(size - 1) + res.get(size - 2) == num)) {
                res.add((int)num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (helper(s, pt + 1, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }            
        }
        
        return false;
    }
}


