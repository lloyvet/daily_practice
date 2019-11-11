package Experiment;

import java.util.Scanner;

public class PolyTest {
    public static void main(String[] args) {
        while(true){
            PolyNomial Pa = new PolyNomial();
            Scanner in = new Scanner(System.in);
            System.out.println("请输入系数和指数：");
            System.out.println("系数和指数为0时停止输入");
            double coef = in.nextDouble();
            int expn = in.nextInt();
            while(coef!=0||expn!=0){
                Pa.insert(new PolyNode(coef,expn));
                coef = in.nextDouble();
                expn = in.nextInt();
            }
            System.out.println("第一个一元多项式为：");
            System.out.println(Pa.printPoly());
            PolyNomial Pb = new PolyNomial();
            coef = in.nextDouble();
            expn = in.nextInt();
            while(coef!=0||expn!=0){
                Pb.insert(new PolyNode(coef,expn));
                coef = in.nextDouble();
                expn = in.nextInt();
            }
            System.out.println("第二个一元多项式为：");
            System.out.println(Pb.printPoly());
            PolyNomial res = new PolyNomial();
            System.out.println("两个一元多项式相加的结果为：");
            System.out.println(res.add(Pa,Pb).printPoly());
            System.out.println("两个一元多项式相减的结果为：");
            System.out.println(res.subtraction(Pa,Pb).printPoly());
        }
    }
}
class PolyNomial{
    PolyNode head;
    PolyNode end;
    public PolyNomial(){
        head = new PolyNode();
        end = head;
        head.next = null;
    }
    //是否为空
    public boolean isEmpty(){
        return head.next == null;
    }
    //插入元素
    public void insert(PolyNode node){
        end.next = node;
        end = node;
    }
    //打印多项式
    public String printPoly(){
        StringBuilder res = new StringBuilder("");
        StringBuilder a = new StringBuilder("");
        StringBuilder b = new StringBuilder("");
        StringBuilder theOne = new StringBuilder("");
        end = head.next;
        int n1 = 0;
        int n2 = 0;
        while(end!=null){
            if(end.getCoef()==0){
                n1++;
            }
            n2++;
            end = end.next;
        }
        if(n1 == n2){
            res.append("0"); //如果系数全为0
        }else{
            end = head.next;
            while(end!=null){
                a.delete(0,a.length());
                b.delete(0,b.length());
                theOne.delete(0,theOne.length());
                if((end.getCoef() == 1 || end.getCoef() == -1)&&end.getExpn()!=0)
                    a.append("");
                else if(end.getCoef() < 0){
                    a.append(String.valueOf(-end.getCoef()));
                }else{
                    a.append(String.valueOf(end.getCoef()));
                }
                if(end.getExpn()==1){
                    b.append("");
                    theOne.append(a.toString()).append("x").append(b.toString());
                }else if(end.getExpn()==0){
                    b.append("");
                    theOne.append(a.toString());
                }else{
                    b.append(String.valueOf(end.getExpn()));
                    theOne.append(a.toString()).append("x").append(b.toString());
                }
                if(end.getCoef()==0){
                    res.append("");
                }else{
                    if(end == head.next && end.getCoef() < 0){
                        res.append("-").append(theOne.toString());
                    }else if(end==head.next&&end.getCoef()>0){
                        res.append(theOne.toString());
                    }else if(end.getCoef()<0){
                        res.append("-").append(theOne.toString());
                    }else{
                        res.append("+").append(theOne.toString());
                    }
                }
                end = end.next;

            }
        }

        return res.toString();
    }
    //多项式加法
    public PolyNomial add(PolyNomial Pa, PolyNomial Pb){
        PolyNomial res = new PolyNomial();
        Pa.end = Pa.head.next; //指向第一个元素
        Pb.end = Pb.head.next;
        while(Pa.end!=null&&Pb.end!=null){
            if(Pa.end.getExpn()==Pb.end.getExpn()){
                res.insert(new PolyNode(Pa.end.getCoef()+Pb.end.getCoef(),Pa.end.getExpn()));
                Pa.end = Pa.end.next;
                Pb.end = Pb.end.next;
            }else if(Pa.end.getExpn()<Pb.end.getExpn()){
                res.insert(Pa.end);
                Pa.end = Pa.end.next;
            }else{
                res.insert(Pb.end);
                Pb.end = Pb.end.next;
            }
        }
        while(Pa.end!=null){
            res.insert(Pa.end);
            Pa.end = Pa.end.next;
        }
        while(Pb.end!=null){
            res.insert(Pb.end);
            Pb.end = Pb.end.next;
        }
        res.end=res.head.next;
        PolyNode tempPrevious=res.end;
        PolyNode temp=res.end.next;
        while(res.end.next!=null){

            while(temp!=null)
            {
                if(temp.getExpn()!=res.end.getExpn())
                {
                    temp=temp.next;
                    tempPrevious=tempPrevious.next;
                }else{
                    res.end.setCoef(res.end.getCoef()+temp.getCoef());
                    tempPrevious.next=temp.next;
                    temp=temp.next;
                }

            }
            res.end=res.end.next;
            tempPrevious=res.end;
            temp=res.end.next;
        }
        res.printPoly();
        return res;
    }
    //多项式减法
    public PolyNomial subtraction(PolyNomial Pa,PolyNomial Pb){
        PolyNomial res = new PolyNomial();
        Pb.end = Pb.head.next;
        //将系数设为相反
        while(Pb.end!=null){
            Pb.end.setCoef(-(Pb.end.getCoef()));
            Pb.end = Pb.end.next;
        }
        Pa.end = Pa.head.next;
        Pb.end = Pb.head.next;
        while(Pa.end!=null&&Pb.end!=null){
            if(Pa.end.getExpn()==Pb.end.getExpn()){
                res.insert(new PolyNode(Pa.end.getCoef()+Pb.end.getCoef(),Pa.end.getExpn()));
                Pa.end = Pa.end.next;
                Pb.end = Pb.end.next;
            } else if (Pa.end.getExpn() < Pb.end.getExpn()) {
                res.insert(new PolyNode(Pa.end.getCoef(),Pa.end.getExpn()));
                Pa.end = Pa.end.next;
            }else {
                res.insert(new PolyNode(Pb.end.getCoef(),Pb.end.getExpn()));
                Pb.end = Pb.end.next;
            }
        }
        while (Pa.end!=null){
            res.insert(new PolyNode(Pa.end.getCoef(),Pa.end.getExpn()));
            Pa.end = Pa.end.next;
        }
        while(Pb.end!=null) {
            res.insert(new PolyNode(Pb.end.getCoef(), Pb.end.getExpn()));
            Pb.end = Pb.end.next;
        }
        return res;
    }
}
class PolyNode{
    double coef; //系数
    int expn; //指数
    PolyNode next ;

    public PolyNode(double coef, int expn) {
        this.coef = coef;
        this.expn = expn;
        this.next = null;
    }
    public PolyNode() {
        this(0,0);
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getExpn() {
        return expn;
    }

    public void setExpn(int expn) {
        this.expn = expn;
    }
}
