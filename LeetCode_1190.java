class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)!=')')
            stack.push(s.charAt(i));
            if(s.charAt(i)==')'){
                StringBuilder sb2 = new StringBuilder();
                while(stack.peek()!='('){
                    sb2.append(stack.pop());
                }
                stack.pop();
                for(int j = 0; j < sb2.length();j++){
                    stack.push(sb2.charAt(j));
                }
                
                
            }
        }
        int length = stack.size();
        for(int i = 0; i < length; i++){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}