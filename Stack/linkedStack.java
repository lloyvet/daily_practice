package Stack;

public class LinkedStack
{
    //
    Node top = new Node() ;

    public void push(int val){
        Node temp = new Node(val);
        if(top.next==null){
            top.next = temp;
        }
        temp.next = top.next;
        top.next = temp;
    }

    public void pop(){
        if(top.next == null)
            return;

        top.next = top.next.next;
    }
    public void getTop(){
        if(top.next!=null){
            System.out.println(top.next.val);
        }
    }

    public boolean isEmpty(){
        return top.next == null ? true : false;
    }

    public void list(){
        Node temp = top.next;
        while(temp.next!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(9);
        stack.push(2);
        stack.pop();
        stack.getTop();

    }
}


class Node{
    int val;
    Node next;
    public Node(){

    }
    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
