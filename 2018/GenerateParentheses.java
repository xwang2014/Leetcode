
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        
        if (n < 1) return res;
        
        dfs(n, res, "", 0, 0);
        
        return res;
    }
    
    private void dfs(int n, List<String> res, String prefix, int left, int right) {
        if (prefix.length() == 2 * n) {
            res.add(prefix);
            return;
        }
        
        if (left < n) {
            dfs(n, res, prefix + "(", left + 1, right);
        }
        if (right < left) {
            dfs(n, res, prefix + ")", left, right + 1);
        }
    }

