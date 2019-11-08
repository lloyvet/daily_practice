package StringDemo;

import java.util.ArrayList;
import java.util.List;

public class StringSort {
    public static void main(String[] args) {
        String[] a = {"4PGC938","2IYE230","3CIO720","1ICK750","1OHV845","4JZY524","1ICK750","3CIO720"};
        Lsd(a,7);
        List<Integer> list = new ArrayList<>();
    }
    //低位优先排序
    public static void Lsd(String[] a,int w){
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for(int d = w - 1; d >= 0; d--){
            //根据第d个字符用键索引计数法排序
            int[] count = new int[R+1];
            for(int i = 0; i < N; i++)  //统计出现频率
                count[a[i].charAt(d)+1]++;
            for(int r = 0; r < R; r++)  //将频率转换为索引
                count[r+1] += count[r];
            for(int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for(int i = 0; i < N; i++){
                a[i] = aux[i] ;
            }
        }
        for(String res:aux){
            System.out.println(res);
        }
    }
}
