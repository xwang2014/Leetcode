
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // check row
        for(int r = 0; r < 9; r++) {
            HashSet<Character> set = new HashSet<Character>();
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.') continue;
                if(set.contains(board[r][c])) return false;
                else set.add(board[r][c]);
            }
        }
        
        // check col 
        for(int c = 0; c < 9; c++) {
            HashSet<Character> set = new HashSet<Character>();
            for(int r = 0; r < 9; r++) {
                if(board[r][c] == '.') continue;
                if(set.contains(board[r][c])) return false;
                else set.add(board[r][c]);
            }
        }        
        
        // check small board
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                HashSet<Character> set = new HashSet<Character>();
                for(int row = 3 * i; row < 3*i + 3; row++) {
                    for(int col = 3 * j; col < 3 * j + 3; col++) {
                        if(board[row][col] == '.') continue;
                        if(set.contains(board[row][col])) return false;
                        else set.add(board[row][col]);
                    }
                }
            }
        }
    
        // check pass
        return true;
    }


}
