package QueueDemo;

public class Queue8 {
    int max = 8;
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queue8 q = new Queue8();
        q.check(0);
        System.out.println(count);
    }
    public void check(int n){
        if(n==max){
            print();
            return ;
        }
        //依次放入看是否冲突
        for(int i = 0; i < max; i++){
            arr[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }

    }
    //查看我们放置第n个皇后就去检测黄狗是否和前面已经摆放的皇后冲突
    //n表示第n个皇后
    public boolean judge(int n){
        for(int i = 0; i < n; i++) {
            //array[i] == array[n]判断第n个皇后是否和前面的n-1个皇后在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i])是否在同一斜线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
    static int count = 0;
    public void print(){
        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        count++;
        System.out.println();

    }
}
