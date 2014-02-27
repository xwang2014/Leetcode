import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class SudokuSolver {
	
    public void dfs(char[][] board, int count) {

        if(count == 81) {
        	//System.err.println("SUCCESS");
            flag = true;
            return;
        }
        if(flag) return;
        
        int r = count / 9;
        int c = count % 9;
        
        if(board[r][c] != '.') {
            dfs(board, count + 1);
        } else {
            ArrayList<Character> options = getOptions(board, r, c);
            
            for(int j  = 0; j < options.size() && !flag ; j++) {
                Character i = options.get(j);
                board[r][c] = i;
                dfs(board, count + 1);
                if(!flag)
                    board[r][c] = '.';
            }
        }
    }
    
    private ArrayList<Character> getOptions(char[][] board, int r, int c) {
        ArrayList<Character> res = new ArrayList<Character>();
        
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < 9; i++) {
            if(board[r][i] != '.') {
                Character t = (board[r][i]);
                set.add(t);
            }
            if(board[i][c] != '.') {
                Character t = (board[i][c]);
                set.add(t);
            }
        }
        
        int row = r / 3, col = c / 3;
        for(int m = 3* row; m < 3 * row + 3; m++) {
            for(int n = 3 * col; n < 3 * col + 3; n++) {
                if(board[m][n] != '.') {
                    set.add(board[m][n]);
                }
            }
        }
        
        for(char cc = '1'; cc <= '9'; cc++) {
            if(!set.contains(cc))
                res.add(cc);
        }
        Collections.sort(res);
        return res;
    }
    
    private boolean flag;
    public void solveSudoku(char[][] board) {
        flag = false;
        dfs(board, 0);
    }

	public static void main(String[] args) {
		SudokuSolver so = new SudokuSolver();
		String[] arr = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		
		char[][] board = new char[9][9];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length(); j++) {
				board[i][j] = arr[i].charAt(j);
			}
		}
		
		print(board);
	
		so.solveSudoku(board);
		
		
		print(board);
	}

	public static void print(char[][] board) {
		System.out.println();
		for(int i = 0; i < board.length; i++) {
			System.out.println();
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
		}			
		System.out.println();
	}
}

