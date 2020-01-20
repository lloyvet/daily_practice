class Solution {
    public int balancedStringSplit(String s) {
        char[] ar = s.toCharArray();
        int arLen = ar.length;
        int count = 0;
        int k= 0;
        int m = 0;
        for(int i = 0; i < ar.length; i++){
            if(ar[i] == 'R'){
                k++;
            }else if(ar[i]=='L'){
                m++;
            }
            if(k == m){
                count++;
                k = 0;
                m = 0;
            }
        }
        return count;
    }
}