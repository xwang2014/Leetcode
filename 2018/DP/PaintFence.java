


    // global[i]  ways for first i fence, the last two fence have different color
    // local[i]    the last two fence have same color
    // global[i] = global[i - 1] * (k - 1) + local[i - 1] * (k - 1) 
    // local[i] = global[i - 1] * 1
    
    public int numWays(int n, int k) {
        if (n < 1 || k < 1) return 0;
        if (n == 1) return k;
        
        int[] global = new int[n];
        int[] local = new int[n];
        
        global[0] = k;
        global[1] = global[0] * (k - 1) + local[0] * (k - 1);
        local[0] = 0;
        local[1] = k;
        
        for (int i = 2; i < n; i++) {
            global[i] = global[i - 1] * (k - 1) + local[i - 1] * (k - 1);
            local [i] = global[i - 1];
        }
        
        return global[n - 1] + local[n - 1];
    }


