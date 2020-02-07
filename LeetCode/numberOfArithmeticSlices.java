public int numberOfArithmeticSlices(int[] A) {
        if(A==null)
            return 0;
        int count = 0;
        int sum = 0;
        for(int i = 2; i < A.length; i++){
            if((A[i-1]-A[i-2])==(A[i]-A[i-1])){
                sum += 1;
                count += sum;
            }else{
                sum = 0;
            }
        }
        return count;
    }