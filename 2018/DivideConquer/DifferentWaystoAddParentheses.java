

    // divide and conquer
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (input == null || input.length() == 0) return res;
        
        compute(input, 0, res);
        
        return res;
    }
    
    private Integer compute(String input, int level, List<Integer> res) {
        Integer ans = 0;
        
        if (input.length() == 1) {
            ans = Integer.parseInt(input);
        }
        
        for (int i = 1; i < input.length() -1; i++) {
            char c = input.charAt(i);
            
            if (c >= '0' && c <= '9') continue;
            
            int left = compute(input.substring(0, i), level + 1, res);
            int right = compute(input.substring(i + 1), level + 1, res);
            
            if (c == '+') {
                ans = left + right;
            } else if (c == '-') {
                ans = left - right;
            } else {
                ans = left * right;
            }
        }

        if (level == 0) {
            res.add(ans);
        }

        return ans;
    }

