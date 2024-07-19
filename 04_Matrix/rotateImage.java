class Solution {

    private void swap(int i, int j, int[][] matrix){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp; 
    }

    private void reverse(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        // transpose the matrix;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                
                // swaping mat[i][j] with mat[j][i]
                swap(i, j, matrix);
            }
        }
        for(int i = 0; i < n; i++){
            reverse(matrix[i]);
        }
        return;
    }
}