package GraphDemo;

import java.util.Arrays;
import java.util.Date;

public class KruskalAlgorithm {
    private int edgeNum; //边的个数
    private char[] vertexs;//顶点数据
    private int[][] martrix;//邻接矩阵
    int maxVal = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int maxVal = Integer.MAX_VALUE;
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] martix = {
                {0,12,maxVal,maxVal,maxVal,16,14},
                {12,0,10,maxVal,maxVal,7,maxVal},
                {maxVal,10,0,3,5,6,maxVal},
                {maxVal,maxVal,3,0,4,maxVal,maxVal},
                {maxVal,maxVal,5,4,0,2,8},
                {16,7,6,maxVal,2,0,9},
                {14,maxVal,maxVal,maxVal,8,9,0}
        };
        KruskalAlgorithm ka = new KruskalAlgorithm(vertexs,martix);
        ka.print();
        Edata[] edges = ka.getEdges();
        ka.sortEdge(edges);
        ka.Kruskal();
    }
    public KruskalAlgorithm(char[] vertexs,int[][] martrix){
        //初始化顶点数和边的个数
        int vlen = vertexs.length;
        this.vertexs = new char[vlen];
        this.martrix = new int[vlen][vlen];
        for(int i = 0; i < vertexs.length; i++){
            this.vertexs[i] = vertexs[i];
        }
        this.martrix = martrix;
        //统计边
        for(int i = 0; i < martrix.length; i++){
            for(int j = i+1; j < martrix[0].length; j++){
                if(this.martrix[i][j]!=Integer.MAX_VALUE)
                edgeNum++;
            }
        }
    }
    public void Kruskal(){
        int index = 0; //表示最够结果数组的索引
        int[] ends = new int[edgeNum]; //用于保存已有的最小生成树
        //创建结果数组
        Edata[] rets = new Edata[edgeNum];
        //获取图中所有边的集合
        Edata[] edges = getEdges();
        System.out.println(Arrays.toString(edges));
        sortEdge(edges);
        //遍历edges将边添加到最小生成树中
        for(int i = 0; i < edgeNum; i++){
            //获取到第i条边的第一个顶点
            int p1 = getPosition(edges[i].start);
            //获取第i条边的第二个顶点
            int p2 = getPosition(edges[i].end);
            //获取p1顶点在最小生成树中的终点
            int m = getEnd(ends,p1);
            //获取p2顶点在最小生成树中的终点
            int n = getEnd(ends,p2);
            //是否构成回路
            if(m != n){//没有构成回路
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }
        System.out.println("------------");
        for (int i = 0; i < index; i++){
            System.out.println(rets[i]);
        }
    }
    public void print(){
        for(int[] link : martrix){
            System.out.println(Arrays.toString(link));
        }
    }
    public void sortEdge(Edata[] edges){
        for(int i = 0; i < edges.length - 1; i++){
            for(int j = 0; j < edges.length - i- 1; j++){
                if(edges[j].weight >= edges[j+1].weight){
                    Edata temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    /**
     *
     * @param ch 顶点的值
     * @return 返回ch顶点对应的下标
     */
    public int getPosition(char ch){
        for(int i = 0; i < vertexs.length; i++){
            if(vertexs[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 功能 获取图中的边放到edata数组中
     * 通过martix玲姐矩阵获取
     *Edata[] ['A','B',12]
     * @return
     */
    public Edata[] getEdges(){
       int index = 0;
       Edata[] edges= new Edata[edgeNum];
        for (int i = 0; i < vertexs.length; i++){
            for(int j = i + 1; j < vertexs.length; j++){
                if(martrix[i][j]!=maxVal){
                    edges[index++] = new Edata(vertexs[i],vertexs[j],martrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 功能   获取下标为v的顶点的终点，用于后面判断两个顶点的终点是否相同
     * @param ends
     * @param v
     * @return
     */
    public int getEnd(int[] ends,int v){
        while (ends[v] != 0){
            v = ends[v];
        }
        return v;
    }
}
class Edata{
    char start;//边的起点
    char end;//边的终点
    int weight;//边的权重

    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edata{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
