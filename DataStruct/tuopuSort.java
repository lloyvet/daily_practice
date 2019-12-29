package GraphDemo;

import java.util.Arrays;
import java.util.Stack;

public class TuopuSort {
    public static void main(String[] args) {
        int nullVal = Integer.MAX_VALUE;
        char[] data = {'1','2','3','4','5','6'};
        int[][] weight = {{nullVal,1,1,1,nullVal,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal},
                {nullVal,1,nullVal,nullVal,1,nullVal},
                {nullVal,nullVal,nullVal,nullVal,1,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal},
                {nullVal,nullVal,nullVal,1,1,nullVal}};
        Graphic graphic = new Graphic(data,weight);
        graphic.showG();
        graphic.getPenetration();
        graphic.printPenetration();
        graphic.tuopu();
    }
}

class Graphic{
    int verxs; //图的结点个数
    char[] data; //存放结点数据
    int[][] weight;//存放边
    int[] Penetration; //存储每个点的入度
    boolean[] isVistied; //该节点是否已输出
    public Graphic(char[] data, int[][] weight) {
        this.verxs = data.length;
        this.data = data;
        this.weight = weight;
        this.Penetration = new int[data.length];
        this.isVistied = new boolean[data.length];
    }
    //拓扑排序
    public void tuopu(){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < Penetration.length; i++){
            if(Penetration[i] == 0){
                isVistied[i] = true;
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(int i = 0; i < weight[0].length; i++){
                if(weight[temp][i]==1){
                    Penetration[i]--;
                }
            }
            for(int i = 0; i < Penetration.length; i++){
                if(Penetration[i] == 0 ){
                    if(!isVistied[i]) {
                        isVistied[i] = true;
                        stack.push(i);
                    }
                }else {
                    continue;
                }
            }
            System.out.print(data[temp]+"->");
        }

    }

    //打印图
    public void showG(){
        for(int[] link : weight){
            System.out.println(Arrays.toString(link));
        }
    }
    //求每个点的入度
    public void getPenetration(){
        for(int i = 0; i < weight.length; i++){
            for(int j = 0; j < weight[0].length; j++){
                if (weight[i][j]==1){
                    Penetration[j]++;
                }
            }
        }
    }
    //打印每个点的入度
    public void printPenetration(){
        System.out.println(Arrays.toString(Penetration));
    }
}