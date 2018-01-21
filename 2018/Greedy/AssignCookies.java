

    // Greedy 
    
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length < 1 || s.length < 1) {
            return 0;
        }
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int content = 0;
        int i = 0, j = 0;
        
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                content++;
                i++;
                j++;
            } else if (g[i] > s[j]) {
                j++;
            }
        } 
        
        return content;
    }


