
    public static String[] board= { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public void dfs(String digits, int idx, String prefix, List<String> res) {
        if (idx == digits.length()) {
            res.add(prefix);
            return;
        }
        
        char c = digits.charAt(idx);
        String letters = board[ (int)(c - '0') ];
        
        for (int i = 0; i < letters.length(); i++) {
            dfs(digits, idx + 1, prefix + letters.charAt(i), res);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        dfs(digits, 0, "", res);
        
        return res;
    }


