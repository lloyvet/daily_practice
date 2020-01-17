package Thread;
/**
 * 卖票案例出现了线程安全问题
 * 卖出了不存在的票和重复的票
 * 解决方案
 *  使用同步代码块
 * 使用步骤
 * 把访问了共享数据的代码出去出来放到一个方法中
 * 在方法上添加synchronize修饰符
 * 格式 定义方法
 * 修饰符 synchronize 返回值类型 方法名（参数列表）{
 *     可能会出现线程安全问题的代码
 * }
 */
public class RunnableImp3 implements Runnable{

    private int ticket = 100;
    //创建锁对象
    Object obj = new Object();
    @Override
    public void run() {
        while(true){
            payTicket();
        }
    }

    /*
    定义一个同步方法
    静态的同步方法
    锁对象不能是this
    this是创建对象之后产生静态方法优先于对象
    静态方法的锁对象是本类的class属性
     */
    public synchronized void payTicket(){
        if(ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //票存在，卖票
            System.out.println(Thread.currentThread().getName()+"----->"+ticket);
            ticket--;
        }
    }
    public static void main(String[] args) {
        RunnableImp3 r = new RunnableImp3();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}
