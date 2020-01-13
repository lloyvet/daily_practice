package Collections;

public class HashMapDemo<K,V> {
    Node[] table; //位数组
    int size;   //存放键值对的个数
    public HashMapDemo(){
        table = new Node[16];
    }
    public void put(K key,V value){
        Node newNode = new Node();
        newNode.hash = gethash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.val = value;
        newNode.next = null;
        Node temp = table[newNode.hash];
        boolean keyRepeat = false;
        Node iterLast = null; //正在遍历的最后一个元素
        if(temp == null){
            //此处数组元素为空，则直接将该节点放进去
            table[newNode.hash] = newNode;
        }else{
            //不为空遍历对应的链表将其添加到尾部
            while(temp!=null){
                //判断如果key重复则覆盖
                if(temp.key.equals(key)){
                    keyRepeat = true;
                    System.out.println("repation key");
                    temp.val = value;
                    break;
                }else{
                    //key不重复
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if(!keyRepeat){//如果发生key重复的情况则添加到链表最后
                iterLast.next = newNode;
            }
        }
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public Object get(K key){
        int hash = gethash(key.hashCode(),table.length-1);
        Object value = null;
        if(table[hash]!=null){
            Node temp = table[hash];
            while(temp!=null){
                if(temp.key.equals(key)){
                    value = temp.val;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }
        return value;
    }
    public String toSting(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < table.length; i++){
            Node temp = table[i];
            while(temp!=null){
                sb.append(temp.key+":"+temp.val+" ");
                temp = temp.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public int gethash(int v,int length){
        System.out.println(v & (length - 1));
        return v & (length - 1);
    }

    public static void main(String[] args) {
        HashMapDemo<Integer,String> m = new HashMapDemo();
        m.put(10,"aa");
        m.put(20,"bb");
        m.put(30,"cc");
        m.put(20,"aaa");
        System.out.println(m.toSting());
        System.out.println(m.get(10));
    }

}


class Node<K,V>{
    int hash;
    Object key;
    Object val;
    Node next;

}