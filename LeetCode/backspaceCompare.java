 public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i)=='#'&&!stack1.isEmpty()){
                stack1.pop();
            }
            else if(S.charAt(i)!='#')
                stack1.push(S.charAt(i));
        }
        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i)=='#'&&!stack2.isEmpty()){
                stack2.pop();
            }
            else if(T.charAt(i)!='#')
                stack2.push(T.charAt(i));
        }
        if(stack1.size()!=stack2.size())
        return false;
        
        for(int i = 0; i < stack1.size(); i++){
            if(!stack1.isEmpty()&&!stack2.isEmpty()&&stack1.pop()!=stack2.pop()){
                return false;
            }
        }
        return true;
    }