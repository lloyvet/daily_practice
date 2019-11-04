package StringDemo;

import java.util.Arrays;

public class StringKMP {
    public static void main(String[] args) {
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";
        System.out.println(s1.charAt(0));
        int[] next = kmpNext("ABCDABD");
        System.out.println(Arrays.toString(next));
        int index = KmpSearc(s1,s2,next);
        System.out.println(index);
    }
    public static int KmpSearc(String s1,String s2,int[] next){
        for(int i = 0, j = 0; i < s1.length(); i++){
            //需要处理s1.charAt(i) ！= s2.charAt(j)
            while(j > 0 && s1.charAt(i) != s2.charAt(j)){
                j = next[j-1];
            }
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            if(j == s2.length())
                return i - j + 1;
        }
        return -1;
    }

    //获取字符串的部分匹配值表
    public static int[] kmpNext(String dest){
        //创建next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1, j = 0; i < dest.length(); i++){
            //当dest.charAt(i)!=dest.charAt(j)需要从next[j-1]获取新的j
            //直到相等时才退出
            while(j > 0 && dest.charAt(i)!=dest.charAt(j)){
                j = next[j-1];
            }
            if(dest.charAt(i) == dest.charAt(j)){   //部分匹配值+1
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    //暴力匹配
    public static int VoilenceMatching(String s1, String s2){
        char[] ar1 = s1.toCharArray();
        char[] ar2 = s2.toCharArray();

        int ar1Len = ar1.length;
        int ar2Len = ar2.length;

        int i = 0;
        int j = 0;
        while(i<ar1Len&&j<ar2Len){
            if(ar1[i] == ar2[j]){
                i++;
                j++;
            }else{
                i = i - (j - 1);
                j = 0;
            }
        }
        System.out.println(j);
        return i - j;
    }

}
