package Oj;

public class Building_blocks {
    public static void main(String[] args) {
        int[] m = {0,1,2,3,4,5,6,7,8,9};
        f(0,m);
        System.out.println(count);

    }
    static int count = 0;
    public static void f(int k, int[] m){
        //优化提前剪枝
        if(k>1&&!check(m,k-1)){ //判断上一个位置是否满足条件
            return ;
        }
        if(k == m.length - 1 && check(m,k)){
            count++;
            return ;
        }
        for(int i = k; i < m.length; i++){
            {
                int t = m[i];   //交换位置
                m[i] = m[k];
                m[k] = t;
            }
            f(k+1,m);//回溯
            {
            
                int t = m[i];
                m[i] = m[k];
                m[k] = t;
            }
        }
    }

    private static boolean check(int[] m, int k) {
        boolean flag = false;
        //题意判断是否成立条件
        if(m[0]<m[1]&&m[0]<m[2]&&m[1]<m[3]&&m[1]<m[4]&&
        m[2]<m[4]&&m[2]<m[5]&&m[3]<m[6]&&m[3]<m[7]
        &&m[4]<m[7]&&m[4]<m[8]&&m[5]<m[8]&&m[5]<m[9])
            flag = true;
        return flag;
    }
}
