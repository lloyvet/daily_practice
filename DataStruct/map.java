package GraphDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    ArrayList<String> vertexList; //存储顶点集合
    //
    int[][] edges;  //存储图对应的邻接矩阵
    int numOfEdges; //边的数目
    //定义boolean[]记录某个结点是否被访问
    private boolean[] isVisited ;
    public static void main(String[] args) {
        int n = 5; //结点的个数
        String Vertexs[] = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        //添加顶点
        for(String Vertex : Vertexs){
            graph.insertVertex(Vertex);
        }

        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
        graph.dfs();
    }

    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }
    //得到第一个邻接结点的下标W
    public int getFirstNeighbor(int index){
        //如果存在返回对应的下标否则返回-1
        for(int j = 0; j < vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for(int j = v2+1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return  -1;
    }
    //深度优先搜索算法
    public void dfs(boolean[] isVisited, int i){
        //首先访问该节点输出
        System.out.print(getValueByIndex(i)+"->");
        //将结点设置已经访问过
        isVisited[i] = true;
        //查找结点i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while(w != -1){  //说明该节点有邻接结点
            if(!isVisited[w])
            dfs(isVisited,w);
            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }
    //对dfs进行重载遍历所有结点并进行dfs
    public void dfs(){
        //遍历所有结点进行回溯
        for(int i = 0; i < getNumOfEdges(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
        }
    }
    //显示图所对应的的矩阵
    public void showGraph(){
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }
    //返回结点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i所对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回两个结点的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1,int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
