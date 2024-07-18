class Solution {
    
    private boolean isSafe(int row, int col, int[][] vis, int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        return row < n && row >= 0 && col < m  && col >= 0 && vis[row][col] == 0 && mat[row][col] == 1;
    }
    private void dfs(int row, int col, String path, int[][] vis, int[][] mat, ArrayList<String> paths){
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        char[] dir = {'U', 'R', 'D', 'L'};
        int n = mat.length;
        int m = mat[0].length;
        
        if(row == n - 1 && col == m-1){
            paths.add(new String(path));
            return;
        }
        
        vis[row][col] = 1;
        
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(isSafe(nRow, nCol, vis, mat)){
                dfs(nRow, nCol, path + dir[i], vis, mat, paths);
            }
        }
        vis[row][col] = 0;
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> paths = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        if(mat[0][0] == 0 || mat[n-1][m-1] == 0) return paths;

        int[][] vis = new int[n][m];
        dfs(0, 0, "", vis, mat, paths);
        return paths;
    }
}