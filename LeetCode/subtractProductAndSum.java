class Solution {
    public int subtractProductAndSum(int n) {
        int[] arr1 = num(n);
        int sum1 = 1;
        int sum2 = 0;
        for(int i = 0;i < arr1.length; i++){
            sum1 *= arr1[i];
            sum2 += arr1[i];
        }
        return sum1 - sum2;
    }
    public int[] num(int n){
        int temp = n;
        int count = 0;
        int mut  = 1;
        while(temp!=0){
            temp /= 10;
            count++;
            mut *= 10;
        }
        mut /= 10;
        int[] arr = new int[count];
        for(int i = 0; i < count; i++){
            arr[i] = n / mut % 10;
            mut /= 10;
        }
        return arr;
    }
}