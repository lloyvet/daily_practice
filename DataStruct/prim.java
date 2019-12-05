package GraphDemo;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};
        //创建图对象
        MGraph graph = new MGraph(data.length);
        int maxValue = Integer.MAX_VALUE;
        int[][] weight = {{maxValue,5,7,maxValue,maxValue,maxValue,2},
                          {5,maxValue,maxValue,9,maxValue,maxValue,3},
                          {7,maxValue,maxValue,maxValue,8,maxValue,maxValue},
                          {maxValue,9,maxValue,maxValue,maxValue,4,maxValue},
                          {maxValue,maxValue,8,maxValue,maxValue,5,4},
                          {maxValue,maxValue,maxValue,4,5,maxValue,6},
                          {2,3,maxValue,maxValue,4,6,maxValue}};
        MinTree minTree = new MinTree();
        minTree.creatGraph(graph,data.length,data,weight);
        minTree.showMGraph(graph);
        minTree.prim(graph,0);
    }
}
//创建最小生成树
class MinTree{
    //创建图的邻接矩阵

    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data  图顶点的数据
     * @param weight    图的邻接矩阵
     */
    public void creatGraph(MGraph graph,int verxs,char[] data,int[][] weight){
        for(int i = 0; i < verxs; i++){
            graph.data[i] = data[i];
            for(int j = 0; j < verxs; j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    //显示图
    public void showMGraph(MGraph graph){
        for(int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
    //prim算法得到最小生成树

    /**
     *
     * @param graph
     * @param v v表示从第几个顶点开始生成最小树
     */
    public void prim(MGraph graph,int v){
        //表示该节点是否已经访问
        boolean[] visited = new boolean[graph.verxs];
        //把当前访问的结点标记为一访问
        visited[v] = true;
        //记录两个顶点下标
        int v1 = -1;
        int v2 = -1;
        int minWeight = Integer.MAX_VALUE; //将minweight初始化成一个最大数在遍历中被替换
        for(int k = 1; k < graph.verxs; k++){//因为有graph.vertxs顶点，prime算法结束后，就只有graph.verxs-1条边
            //确定每一次生成的子图和哪个结点和当前遍历节点的距离最近
            for(int i = 0; i < graph.verxs; i++){
                for(int j = 0; j < graph.verxs; j++){
                    if(visited[i]&&!visited[j]&&graph.weight[i][j]<minWeight) {
                        //寻找已经访问过结点和未访问结点间权值最小的边
                        minWeight = graph.weight[i][j];
                        v1 = i;
                        v2 = j;
                    }
                }
            }
            System.out.println("<"+graph.data[v1]+','+graph.data[v2]+">"+"->"+minWeight);
            //v1,v2以访问
            visited[v1] = true;
            visited[v2] = true;
            minWeight = Integer.MAX_VALUE;
        }
    }
}



class MGraph{
    int verxs; //图的结点个数
    char[] data; //存放结点数据
    int[][] weight;//存放边

    public MGraph(int verxs) {
        this.verxs = verxs;
        this.data = new char[verxs];
        this.weight = new int[verxs][verxs];
    }
}