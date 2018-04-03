    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int[][] num = new int[grid.length][grid[0].length];
        int res = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'E') {
                    res = Math.max(res, process(grid, i, j, num) );
                }
            }
        }
        
        return res;
    }
    
    private int process(char[][] grid, int r, int c, int[][] num) {
        int max = 0;
        
        // up 
        for (int row = r - 1; row >= 0; row--) {
            if (grid[row][c] == 'W') break;
            if (grid[row][c] == 'E') continue;
            
            num[row][c] += 1;
            max = Math.max(max, num[row][c]);
        }
        
        // down
        for (int row = r + 1; row < grid.length; row++) {
            if (grid[row][c] == 'W') break;
            if (grid[row][c] == 'E') continue;
            
            num[row][c] += 1;   
            max = Math.max(max, num[row][c]);
        }
        
        // left
        for (int col = c - 1; col >= 0; col--) {
            if (grid[r][col] == 'W') break;
            if (grid[r][col] == 'E') continue;
            
            num[r][col] += 1;   
            max = Math.max(max, num[r][col]);            
        }
        
        // right
        for (int col = c + 1; col < grid[0].length; col++) {
            if (grid[r][col] == 'W') break;
            if (grid[r][col] == 'E') continue;
            
            num[r][col] += 1;   
            max = Math.max(max, num[r][col]);              
        }
        
        return max;
    }
