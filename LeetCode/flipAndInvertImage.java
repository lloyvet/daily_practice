    public int[][] flipAndInvertImage(int[][] A) {
        int[][] B = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                B[i][j] = A[i][A[i].length-j-1];
            }
        }
         for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
               if(B[i][j]==1)
                   B[i][j] = 0;
                else if(B[i][j] == 0)
                    B[i][j] = 1;
            }
        }
        return B;
    }