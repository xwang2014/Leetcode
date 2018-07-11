
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    expand(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void expand(int[][] rooms, int x, int y, int dis) {
        if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length) {
            return;
        }
        if (rooms[x][y] == -1 || rooms[x][y] < dis) {
            return;
        }
        
        rooms[x][y] = dis;
        
        // up 
        expand(rooms, x, y - 1, dis + 1);
        // down
        expand(rooms, x, y + 1, dis + 1);
        // left
        expand(rooms, x - 1, y, dis + 1);
        // right
        expand(rooms, x + 1, y, dis + 1);
    }
}


