package Leetcode;

import java.util.Stack;

public class Flip_words_in_a_string {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("ascafag");

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(sb.length()!=0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
            }else{
                sb.append(s.charAt(i));
            }
        }
        if(stack.isEmpty())
            return;
        StringBuilder res = new StringBuilder();
        res.append(stack.pop());
        while(!stack.isEmpty()){
            res.append(" ");
            res.append(stack.pop());
        }
        System.out.println(res.toString());
    }
}
