package Collections;

public class Arraylist <E>{
	//
    Object[] elementData;
    int size;
    private static final int DEFALT_CAPACITY = 10;
    public Arraylist(){
        this.elementData = new Object[DEFALT_CAPACITY];
    }
    public Arraylist(int capacity){
        this.elementData = new Object[capacity];
    }
    public void add(E element){
        if(size == elementData.length){
            Object[] newArray = new Object[elementData.length<<1+elementData.length];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }
    public E get(int index){
        if(index<0 || index > size - 1)
            throw new RuntimeException();
        return (E)elementData[index];
    }
    public void set(E element, int index){
        if(index<0 || index > size - 1)
            throw new RuntimeException();
        elementData[index] = element;
    }
    public void remove(int index){
        int numM = elementData.length - index - 1;
        if(numM > 0){
            System.arraycopy(elementData,index+1,elementData,index,numM);
            elementData[size - 1] = null;
        }else{
            elementData[size - 1] = null;
        }
        size--;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return  size == 0;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    public static void main(String[] args) {
        Arraylist s1 = new Arraylist(20);
        for(int i = 0; i < 40; i++){
            s1.add(i); 
        }
        s1.remove(0);
        System.out.println(s1.toString());
    }
}
