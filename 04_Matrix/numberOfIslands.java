class Solution {

    private boolean isSafe(int row, int col, char[][] grid, int[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        return row < n && row >= 0 && col < m && col >= 0 && grid[row][col] == '1' && visited[row][col] == 0;
    }
    private void dfs(int row, int col, char[][] grid, int[][] visited) {
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        visited[row][col] = 1;

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(isSafe(nRow, nCol, grid, visited)){
                dfs(nRow, nCol, grid, visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
}