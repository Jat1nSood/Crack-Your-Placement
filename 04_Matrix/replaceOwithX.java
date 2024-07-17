class Solution {

    private boolean isSafe(int row, int col, char[][] board, int[][] visited){
        int n = board.length;
        int m = board[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && board[row][col] == 'O' && visited[row][col] == 0;
    }

    private void dfs(int row, int col, char[][] board, int[][] visited){
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        visited[row][col] = 1;

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(isSafe(nRow, nCol, board, visited)){
                dfs(nRow, nCol, board, visited);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++){
            if(visited[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, board, visited);
            }
            if(visited[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1, board, visited);
            }
        }
        for(int j = 0; j < m; j++){
            if(visited[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, board, visited);
            }
            if(visited[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1, j, board, visited);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }

    }
}