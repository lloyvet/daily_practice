 public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] arr = new int[n][n];
        List<Integer> lastRow = triangle.get(n-1);
        for(int i = 0; i < n; i++){
            arr[n-1][i] = lastRow.get(i);
        }
        for(int i = n - 2; i >=0; i--){
            List<Integer> row = triangle.get(i);
            for(int j = 0; j < i + 1; j++){
                arr[i][j] = Math.min(arr[i+1][j],arr[i+1][j+1])+row.get(j);
            }
        }
        return arr[0][0];
    }