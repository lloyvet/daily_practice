package Algorithm;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1,4,3};
        int[] value = {1500,3000,2000};
        int capacity = 4; //背包容量
        int n = value.length; //物品个数
        int path[][] = new int[n+1][capacity+1];
        //创建二维数组
        int[][] v = new int[n+1][capacity+1];
        for (int i = 0; i < v.length; i++){
            v[i][0] = 0;    //第一列设置为0
        }
        for(int i = 0; i < v[0].length; i++){
            v[0][i] = 0;    //第一行设置为0
        }
        //动态规划
        for(int i = 1; i < v.length; i++){
            for(int j = 1; j < v[i].length; j++){
                if(weight[i-1] > j){
                    v[i][j] = v[i-1][j];
                }else{
                    //v[i][j] = Math.max(v[i-1][j], value[i-1]+v[i-1][j-weight[i-1]]);
                    if(v[i-1][j]<value[i-1]+v[i-1][j-weight[i-1]]){
                        v[i][j] = value[i-1]+v[i-1][j-weight[i-1]];
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < v[i].length; j++){

                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
        int i = path.length - 1;
        int j = path[0].length - 1;
        while(i > 0 && j > 0) { //从path最后开始查找
            if(path[i][j] == 1) {
                System.out.println("第"+i+"个商品放入背包");
                j -= weight[i-1];
            }
            i--;
        }
    }
}
