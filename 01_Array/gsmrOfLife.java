class Solution {

    boolean isSafe(int row, int col, int n, int m){
        return row < n && row >= 0 && col < m && col >= 0;
    }

    int getNewState(int oldState, int alive, int dead){

        if(oldState == 0 || oldState == -2){
            if(alive == 3) return -1;
            else return 0;
        } else{
            if(alive > 3 || alive < 2) return -2;
            return 1;
        }
    }
    public void gameOfLife(int[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] delCol = {-1, 0, +1, +1, +1, 0, -1, -1};

        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                int alive = 0;
                int dead = 0;
                for(int k = 0; k < 8; k++){
                    int nRow = i + delRow[k];
                    int nCol = j + delCol[k];
                    if(isSafe(nRow, nCol, n, m)){
                        if(board[nRow][nCol] == 1) alive++;
                        else if(board[nRow][nCol] == -1) dead++;
                        else if(board[nRow][nCol] == -2) alive++;
                        else dead++;
                    }  

                }

                board[i][j] = getNewState(board[i][j], alive, dead);
            }
        }

         for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){

                if(board[i][j] == -1) board[i][j] = 1;
                else if( board[i][j] == -2) board[i][j] = 0;
            }
         }
    }
}


// dead -> dead = 0
// dead -> alive = -1;
// alive -> dead -> -2
// alive to alive -> 1

// First -> Any Live < 2(live neigh) with die
// Second -> Any Live cell with 2 || 3 (live neigh) will live
// Third -> Any Live cell having > 3 live meigh will die
// fourth-> any dead cell will become alive if exactly trhree neigh are alive

// 0 1 1 1 0 
// 0 1 0 1 0 
// 0 1 1 1 0



// 0 -> Dead Cell
// 1 -> Live Cell




// if a cell was dead and still it is dead keep it 0
// if a cell was a dead and now it is alive mark it -1
// if a cell was alive and not it is dead mark it -2
// if a cell was alive and it is still alive mark it 1


