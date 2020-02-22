 static int sum = 0;
    public int sumNums(int n) {
        if(n==0)
            return sum;
        return n+sumNums(n-1);
    }