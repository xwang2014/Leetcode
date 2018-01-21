
    
    // DFS
    // refer : http://blog.csdn.net/qq508618087/article/details/51758481
    
    boolean[] visited; // 
    int[][] hash; // 
    int result = 0;
    
    private void initialize() {
        hash[1][3] = hash[3][1] = 2;  
        hash[1][7] = hash[7][1] = 4;  
        hash[3][9] = hash[9][3] = 6;  
        hash[7][9] = hash[9][7] = 8;  
        hash[2][8] = hash[8][2] = hash[4][6] = hash[6][4] = 5;  
        hash[1][9] = hash[9][1] = hash[3][7] = hash[7][3] = 5;
    }
    
    private boolean validStep(int start, int dest) {
        if (visited[dest]) {
            return false;
        }
        
        if (hash[start][dest] != 0) {
            return visited[hash[start][dest]];
        }
        
        return true;
    }
    
    private void dfs(int m, int n, int idx, int step) {
        if (step >= m) {
            result++;
        }
        
        if (step == n) {
            return;
        }
        
        for (int i = 1; i <= 9; i++) {
            if (validStep(idx, i)) {
                visited[i] = true;
                dfs(m, n, i, step + 1);
                visited[i] = false;
            }
        }
    }
    
    public int numberOfPatterns(int m, int n) {
        
        visited = new boolean[10];
        hash = new int[10][10];
        result = 0;
        
        initialize();
        
        for (int i = 1; i <= 9; i++) {
            visited[i] = true;
            dfs(m, n, i, 1);
            visited[i] = false;
        }
        
        return result;
    }


