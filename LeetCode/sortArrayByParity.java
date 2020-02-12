 public int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int num = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]%2==0){
                arr[num] = A[i];
                num++;
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i]%2!=0){
                arr[num] = A[i];
                num++;
            }
        }
        return arr;
    }