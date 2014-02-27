

public class Search2DMatrix {
    private int findRow(int[][] matrix, int target, int start, int end) {
        if(start == end) return start;
        
        if(target < matrix[start][0]) return -1;
        if(target > matrix[end][0]) return end;
        
        int mid = start + (end - start) / 2;
        int val = matrix[mid][0];
        
        if(val <= target) {
            if(target < matrix[mid+1][0]) return mid;
            else return findRow(matrix, target, mid + 1, end);
        } else {
            if(target >= matrix[mid - 1][0]) return mid - 1;
            return findRow(matrix, target, start, mid - 1);
        }
    }
    
    private int findCol(int[][] matrix, int target, int row, int start, int end) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        int val = matrix[row][mid];
        if(val == target) return mid;
        if(target < val) {
            return findCol(matrix, target, row, start, mid - 1);
        } else {
            return findCol(matrix, target, row, mid + 1, end);
        }
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
        
        int m = matrix.length, n = matrix[0].length;
        int r = findRow(matrix, target, 0, m - 1);
        if(r == -1) return false;
        
        int c = findCol(matrix, target, r, 0, matrix[r].length - 1);
        
        if(c == -1) return false;
        else return true;
    }

}
