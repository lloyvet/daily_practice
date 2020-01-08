package GraphDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class criticalPath {
    public static void main(String[] args) {
        int nullVal = Integer.MAX_VALUE;
        int[][] martix = {{nullVal,6,4,5,nullVal,nullVal,nullVal,nullVal,nullVal,8},
                {nullVal,nullVal,nullVal,nullVal,1,nullVal,nullVal,nullVal,nullVal,nullVal},
                {nullVal,nullVal,nullVal,nullVal,1,nullVal,nullVal,nullVal,nullVal,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,2,nullVal,nullVal,nullVal,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,9,7,nullVal,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,4,nullVal,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,2,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,4,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal},
                {nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,nullVal,10,nullVal}
        };
        int edges = 0;
        for(int i = 0; i < martix.length ; i++){
            for(int j = 0; j < martix[0].length; j++){
                if(martix[i][j] != Integer.MAX_VALUE)
                    edges++;
            }
        }
        char[] vertex = {'1','2','3','4','5','6','7','8','9','0'};
        graph g = new graph(vertex,martix,edges);
        //g.showG();
        boolean flag =g.ifrecycle(0);
        System.out.println();
       if(!flag){
           g.dfs(0);
           System.out.println();
           g.addEdge();
           g.getEdg();
           g.getPenetration();
           g.tuopu();
           g.getVe();
           g.getVI();
           g.getL();
           g.gete();
           g.criticalPath();

       }
    }
}

class graph{
    char[] vertex; //顶点
    int[][] martix; //存储图
    int[] Penetration; //存储每个点的入度
    boolean[] isVistied; //该节点是否已输出
    int[] Ve; //当前时间的最早发生时间
    int[] VE;
    int[] VI; //当前时间的最迟发生时间
    int[] e;   //当前活动的最早开始时间
    int[] L;    //当前活动的最迟开始时间
    int[] end; //完成当前活动时间的余量
    int[] edge;
    boolean[] Vistied;
    int edges = 0;
    Edge[][] ed;
    Edge[] edg;
    Edge[] Ed;
    //最终的关键路径为end = 0
    public graph(char[] vertex, int[][] martix,int edges) {
        this.vertex = vertex;
        this.martix = martix;
        Penetration = new int[vertex.length];
        isVistied = new boolean[vertex.length];
        Ve = new int[vertex.length];
        VI = new int[vertex.length];
        e = new int[edges];
        L = new int[edges];
        end = new int[edges];
        edge = new int[edges];
        ed = new Edge[edges][edges];
        VE = new int[vertex.length];
        edg = new Edge[edges];
        Vistied = new boolean[vertex.length];

    }
    //得到第一个邻接结点的下标W
    public int getFirstNeighbor(int index){
        //如果存在返回对应的下标否则返回-1
        for(int j = 0; j < vertex.length; j++){
            if(martix[index][j] !=Integer.MAX_VALUE){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for(int j = v2+1; j < vertex.length; j++) {
            if (martix[v1][j] != Integer.MAX_VALUE) {
                return j;
            }
        }
        return  -1;
    }

    //深度优先搜索算法
    public boolean ifrecycle(int i){
        //将结点设置已经访问过
        isVistied[i] = true;
        //查找结点i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while(w != -1){  //说明该节点有邻接结点
            if(isVistied[w])
                return true;
            if(!isVistied[w])
                ifrecycle(w);

            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }
        //遍历完v的所有邻接点，为发现回路，顶点v返回
        isVistied[i] = false; //清楚访问记录
        return false; //没有回路
    }

    public void dfs(int i){

        //首先访问该节点输出
        System.out.print(vertex[i]+"->");
        //将结点设置已经访问过
        Vistied[i] = true;
        //查找结点i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while(w != -1){  //说明该节点有邻接结点
            if(!Vistied[w])
               dfs(w);
            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }

    }
    public void getEdg(){
        for(int i = 0, k = 0; i < ed.length; i++){
            for(int j = 0; j < ed[0].length; j++){
                if(ed[i][j]!=null){
                    edg[k] = new Edge(ed[i][j].start,ed[i][j].end,ed[i][j].weight);
                    k++;
                }
            }
        }
        for(int i = 0; i < edg.length; i++){
            System.out.println(edg[i]);
        }
    }

    //关键路径
    public void criticalPath() {
        int n = 0;
        for (int i = 0; i < end.length; i++) {
            end[i] = L[i] - e[i];

        }
        for(int i = 0; i < end.length; i++){
            if(end[i] == 0)
                n++;
        }
        Ed = new Edge[n];
        System.out.println("关键路径");
        System.out.println(Arrays.toString(end));
        int k = 0;
        for (int i = 0; i < end.length; i++) {
            if(end[i] == 0) {
                System.out.println(vertex[edg[i].start] + " ->" + vertex[edg[i].end]); //1 5 7 8 9
                Ed[k++] = new Edge(edg[i].start, edg[i].end, 0);

            }
        }
        System.out.println(Ed.toString());
        int count = 0;
        for(int i = 0; i < Ed.length; i++) {
            if(Ed[i].end == edg[edg.length - 1].end)
                count++;
        }
        System.out.println("edg");
        for(int i = 0; i < edg.length; i++){
            System.out.println(edg[i]);
        }
        System.out.println("Ed");
        for(int i = 0; i < Ed.length; i++){
            System.out.println(Ed[i]);
        }
        boolean[] sv = new boolean[edg.length];
        for(int i = 0; i < edg.length; i++){
            for(int j = 0; j < Ed.length; j++){
                if(edg[i].start == Ed[j].start && edg[i].end == Ed[j].end){
                    sv[i] = true;
                    break;
                }
            }
            System.out.print(sv[i]+" ");
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l =0;
        for(int i = 0; i < Ed.length; i++){
            if(Ed[i].start == 0 ) {
                res.add(new ArrayList<>(l));
                boolean[] vs = new boolean[Ed.length];
                criticalpath(i,vs,res,l);
                res.get(l).add(8);
                System.out.println(8);
                System.out.println();
                l++;
            }else
                continue;
        }
    }

    public int getEdgfirst(int index){
        for(int j = 0; j < Ed.length; j++){
            if(Ed[index].end == Ed[j].start)
             return j;
        }
        return -1;
    }

    public void criticalpath(int i,boolean[] vs, ArrayList<ArrayList<Integer>> res,int l){
        System.out.print(Ed[i].start+"->");
        vs[i] = true;
        int w = getEdgfirst(i);
        while( w != -1){
            if(!vs[w])
                criticalpath(w,vs,res,l);
            w = -1;
        }
    }
    //添加边，以及边对应的权值
    public void addEdge(){
        for(int i = 0; i < martix.length; i++){
            for(int j = 0; j < martix.length; j++){
                if(martix[i][j]!=Integer.MAX_VALUE){
                    ed[i][j] = new Edge(i,j,martix[i][j]);
                }
            }
        }
    }
    //求Ve
    public void getVe(){
        int j = 0;
        while(j  < martix.length){
            for(int i = 0; i < martix.length; i++){
                if(martix[i][j] != 0 && martix[i][j] != Integer.MAX_VALUE){
                    Ve[j] = Math.max(Ve[i] + martix[i][j],Ve[j]);//当前结点的值，和上一个已经求得的Ve
                    VE[j] = Math.max(Ve[i] + martix[i][j],Ve[j]);
                }
            }
            j++;
        }
        System.out.println();
        System.out.println("Ve");
       // System.out.println(Arrays.toString(Ve));
    }
    //求VI
    public void getVI(){
        VI = Ve;
        for(int i = martix.length - 1; i >= 0; i--){
            for(int j = martix[0].length - 1; j >= 0; j--){
                if(martix[i][j]!=Integer.MAX_VALUE)
                VI[i] = Math.min(VI[j] - martix[i][j],VI[j]);
            }
        }
        System.out.println("VI");
        System.out.println(Arrays.toString(VI));
    }
    //求e
    public void gete(){

        for(int i = 0, k = 0; i < martix.length; i++){
            for(int j = 0; j < martix[0].length; j++){
                if(martix[i][j]!=Integer.MAX_VALUE){
                    e[k] = Math.min(VE[j] - martix[i][j],VE[i]);
                    k++;
                }
            }
        }
        System.out.println("e");
        System.out.println(Arrays.toString(e));
    }
    //求L
    public void getL(){
            for(int i = 0, k = 0; i <martix.length; i++){
                for(int j = 0; j < martix[0].length; j++){
                    if(martix[i][j]!=Integer.MAX_VALUE){
                        L[k] = VI[j] - ed[i][j].weight;
                        k++;
                    }
                }
            }
        System.out.println("L");
        System.out.println(Arrays.toString(L));
    }
    //拓扑排序
    public void tuopu(){
        System.out.println("tuopuSort");
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < Penetration.length; i++){
            if(Penetration[i] == 0){
                isVistied[i] = true;
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(int i = 0; i < martix[0].length; i++){
                if(martix[temp][i]!=Integer.MAX_VALUE){
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
            System.out.print(vertex[temp]+"->");
        }

    }

    //打印图
    /*public void showG(){
        for(int[] link : martix){
            System.out.println(Arrays.toString(link));
        }
    }*/
    //求每个点的入度
    public void getPenetration(){
        for(int i = 0; i < martix.length; i++){
            for(int j = 0; j < martix[0].length; j++){
                if (martix[i][j]!=Integer.MAX_VALUE){
                    Penetration[j]++;
                }
            }
        }
    }
    //打印每个点的入度
    public void printPenetration()
    {
        System.out.println(Arrays.toString(Penetration));

    }
}

class Edge{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
