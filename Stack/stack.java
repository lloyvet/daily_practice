package Stack;
import java.util.Scanner;
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出");
            System.out.println("push: 添加");
            System.out.println("pop: 输出");
            key = scanner.next();
            switch(key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println(res);
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case"exit":
                    scanner.close();
                    loop = false;
                    break;

            }
        }
    }
}
class  ArrayStack{
    private int maxSize;  //栈的大小
    private int[] stack;  //数组，数组模拟栈，数据放在数组里
    private int top = -1;

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }
    //栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if(isFull()){
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("没有元素");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历
    public void list(){
        if(isEmpty()){
            System.out.println("null");
        }
        for(int i = top; i >= 0; i--){
            System.out.print(stack[i]);
        }
    }
}