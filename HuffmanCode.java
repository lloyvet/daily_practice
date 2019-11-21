package HuffmanCode;

import java.util.*;

public class HuffmanTreeCode {
    public static void main(String[] args) {
        String content = "good good study day day up";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);

        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(huffmanCodesBytes));
        /*List<Node> nodes = getNodes(contentBytes);
        Node root = createHuffmanCode(nodes);
        root.preOrder();
        getCodes(root,"",sb);
        System.out.println(huffmanCodes);
        byte[] huffmanCodesBy = zip(contentBytes, huffmanCodes);
        System.out.println(Arrays.toString(huffmanCodesBy));*/
    }
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建赫夫曼树
        Node huffmanroot = createHuffmanCode(nodes);
        //对应的赫夫曼编码
        Map<Byte,String> huffmanCodes = getCodes(huffmanroot);
        //得到相对应的字节数组
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
        return huffmanCodeBytes;
    }
    //将字符串对应的byte[]生成赫夫曼编码表
    private static byte[] zip(byte[] bytes, Map<Byte,String> huffmanCodes){
        //1利用huffmancodes将bytes转成赫夫曼对应的编码
        for(byte b : bytes){
            sb.append(huffmanCodes.get(b));
        }
        int len;
        if(sb.length()%8==0){
            len = sb.length() / 8;
        }else{
            len = sb.length() / 8 + 1;
        }
        //创建huffmancodebytes
        byte[] by = new byte[len];
        int index = 0;
        for(int i = 0; i < sb.length(); i += 8){
            //每8位对应一个byte
            String strByte;
            if(i+8 > sb.length()){
                strByte = sb.substring(i);
            }else
                strByte = sb.substring(i,i+8);

            by[index] = (byte)Integer.parseInt(strByte,2);
            index++;
        }
        return by;
    }
    //重载getcodes
    private static Map<Byte,String> getCodes(Node root){
        if(root == null)
            return null;
        getCodes(root.left,"0",sb);
        getCodes(root.right,"1",sb);
        return huffmanCodes;
    }
    //生成赫夫曼对应的编码
    //1将赫夫曼编码表存放在Map<Byte,Integer>中
    //32->01 97->100 100->11000等等
    //2在生成赫夫曼编码表示需要去拼接路径定义一个StringBuilder存储某个叶子结点的路径
    static StringBuilder sb = new StringBuilder();
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    private static void getCodes(Node node, String code, StringBuilder sb){
        //node将node结点所有的叶子结点的赫夫曼编码得到并放入到huffmancodes集合中
        //code路径左子节点为0右子节点为1
        //StringBuilder用来拼接路径
        StringBuilder sb2 = new StringBuilder(sb);
        //将code加入sb2中
        sb2.append(code);
        if(node != null){ //如果node == null不处理
            //判断当前node是叶子结点还是非叶子结点
            if(node.data==null){    //非叶子结点
                //递归处理
                //向左
                getCodes(node.left,"0",sb2);
                //向右
                getCodes(node.right,"1",sb2);
            }else{//说明是叶子结点
                //表示找到某个叶子结点的最后
                huffmanCodes.put(node.data,sb2.toString());

            }

        }
    }
    public static void preOrder(Node root){
        if(root!=null)
            root.preOrder();
        else
            return;
    }
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> arr = new ArrayList<>();
        //存储每个byte出现的次数
        HashMap<Byte,Integer> map = new HashMap<Byte, Integer>();
        for(byte b : bytes){
            Integer count = map.get(b);
            if(count == null){
                map.put(b,1);
            }else{
                map.put(b,count+1);
            }
        }
        for(Map.Entry<Byte,Integer> entry : map.entrySet() ){
            arr.add(new Node(entry.getKey(),entry.getValue()));
        }
        return arr;
    }

    private static Node createHuffmanCode(List<Node> nodes){
        while(nodes.size() > 1){
            Collections.sort(nodes);
            Node leftR = nodes.get(0);
            Node rightR = nodes.get(1);
            Node parent = new Node(null,leftR.weight+rightR.weight);
            parent.left = leftR;
            parent.right = rightR;
            nodes.remove(leftR);
            nodes.remove(rightR);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    Byte data; //存放数据本身
    int weight; // 权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public  void preOrder(){

        System.out.println(this);
        if(this.left!=null)
            this.left.preOrder();
        if(this.right!=null)
            this.right.preOrder();

    }
}
