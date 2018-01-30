


    public void solveSudoku(char[][] board) {
        
        if (board == null || board.length == 0) return;
        
        dfs(board, 0);
        
    }
    
    private boolean dfs(char[][] board, int idx) {
        if (idx == 81) {
            return true;
        }
        
        int r = idx / 9;
        int c = idx % 9;
        
        if (board[r][c] != '.') {
            return dfs(board, idx + 1);
        } else {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (isValid(board, r, c, ch)) {
                    board[r][c] = ch;
                    
                    if(dfs(board, idx + 1)) {
                        return true;
                    } else {
                        board[r][c] = '.';
                    }
                                    
                }
            }
            
            return false;
        }
        
    }
    
    private boolean isValid(char[][] board, int r, int c, char d) {
        
        // Check row and col
        for (int i = 0; i < 9; i++) {
            if (board[i][c] != '.' && board[i][c] == d) return false;
            if (board[r][i] != '.' && board[r][i] == d) return false;
        }
        
        // check cell
        int i = r / 3; 
        int j = c / 3;
        for(int m = 3 * i + 0; m < 3 * i + 3; m++ ) {
            for(int n = 3 * j + 0; n < 3 * j + 3; n++) {
                if(board[m][n] != '.' && board[m][n] == d) {
                    return false;
                }
            }
        }
        
        return true;
    }


