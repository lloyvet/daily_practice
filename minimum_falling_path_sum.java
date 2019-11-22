package Leetcode;

public class minimum_falling_path_sum {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(arr));
    }
    public static int minFallingPathSum(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i = 0; i < m; i++){
            dp[0][i] = arr[0][i];
        }
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1])+arr[i][0];  //处理第一列
            //处理中间列
            for(int j = 1; j < m - 1; j++){
                dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]) + arr[i][j];
            }
            //处理最后一列
            dp[i][m-1] = Math.min(dp[i-1][m-1],dp[i-1][m-2]) + arr[i][m-1];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            res = Math.min(res,dp[n-1][i]);
        }
        return res;
    }
}
