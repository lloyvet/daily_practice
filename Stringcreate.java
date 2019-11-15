package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringCreate {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        int n = 3;
        dfss("",0,0,res,n);
        System.out.println(res);
    }
    public static void dfs(String curStr,int left,int right,List<String> res){
        if(left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        if(left>0){
            dfs(curStr+"(",left-1,right,res);
        }
        if(right>0&&left<right){
            dfs(curStr+")",left,right-1,res);
        }
    }
    public static void dfss(String curStr,int left,int right,List<String> res,int n){
        if(left == n && right == n){
            res.add(curStr);
            return ;
        }
        if(left<n){
            dfss(curStr+"(",left+1,right,res,n);
        }
        if(right<n&&left>right){
            dfss(curStr+")",left,right+1,res,n);
        }
    }

}
23:23 2019/11/14