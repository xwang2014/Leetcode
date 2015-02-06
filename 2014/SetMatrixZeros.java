
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
        
        Integer row = null, col = null;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(row == null && col == null) {
                        row = i;
                        col = j;
                    }
                    
                    matrix[row][j] = 0;
                    matrix[i][col] = 0;
                }
                
            }
        }
        
        if(row == null || col == null) return;
        
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < n; i++) {
            if(matrix[row][i] == 0 && i != col) setCol(matrix, i);
        }
        
        for(int i = 0; i < m; i++) {
            if(matrix[i][col] == 0 && i != row) setRow(matrix, i);
        }
        
        setRow(matrix, row);
        setCol(matrix, col);
        
    }
    
    private void setRow(int[][] matrix, int r) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[r][j] = 0;
        }
    }
    
    private void setCol(int[][] matrix, int c) {
        for(int j = 0; j < matrix.length; j++) {
            matrix[j][c] = 0;
        }        
    }
}

