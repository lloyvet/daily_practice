class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        
        int[][] res = new int[mat.length][mat[0].length];    
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                res[i][j] = setNum(mat,i,j,K);
            }
        }
        return res;
    }
    public int setNum(int[][] mat,int m, int n,int k){
        int sum = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
               if((i>=m - k&&i <= m + k && i>= 0 )&&
                 (j >= n - k && j >= 0 && j <= n + k )){
                   sum += mat[i][j];
               }
            }
        }
        return sum;
    }
}