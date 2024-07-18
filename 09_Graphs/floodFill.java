class Solution {

    private boolean isSafe(int row, int col, int[][] visited, int[][] image, int color){
        int n = image.length;
        int m = image[0].length;
        return row < n && row >= 0 && col < m && col >= 0 && image[row][col] == color && visited[row][col] == 0;
    }

    private void dfs(int row, int col, int[][] visited, int[][] image, int color){

        visited[row][col] = 1;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){

            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(isSafe(nRow, nCol, visited, image, color)){
                dfs(nRow, nCol, visited, image, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;
        int[][] visited = new int[n][m];

        dfs(sr, sc, visited, image, image[sr][sc]);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 1) image[i][j] = color;
            }
        }
        return image;
    }
}