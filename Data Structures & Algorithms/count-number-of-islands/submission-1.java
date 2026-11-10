class Solution {
    public static final int[][] DIRECTIONS = {
        {0, -1}, 
        {1, 0}, 
        {0, 1},
        {-1, 0}
    };
    public void bfsVisit(char[][] grid, int row, int col) {

        var q = new ArrayDeque<int[]>();
        grid[row][col] = '0';
        q.offer(new int[] {row, col});

        while (!q.isEmpty()) {
            var coords = q.poll();
            int x = coords[0];
            int y = coords[1];
            
            for (var direction : DIRECTIONS) {
                int a = x + direction[0];
                int b = y + direction[1];
                if (a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == '1') {
                    grid[a][b] = '0';
                    q.offer(new int[] {a, b});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfsVisit(grid, i, j);
                    result++;
                }
            }
        }
        
        return result;
    }
}
