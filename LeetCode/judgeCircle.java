class Solution {
    public boolean judgeCircle(String moves) {
        int n1 = 0;
        int n2 = 0;
        for(int i = 0; i < moves.length(); i++){
            char ar = moves.charAt(i);
            if(ar=='U')
                n1++;
            else if(ar=='D')
                n1--;
            else if(ar=='R')
                n2++;
            else if(ar=='L')
                n2--;
            
        }
        return (n1==0&&n2==0);
        
    }
}