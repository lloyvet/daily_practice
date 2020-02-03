public int calPoints(String[] ops) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(String str : ops){
            if(str.equals("+")){
                int start = stack.pop();
                int end = stack.peek() + start;
                stack.push(start);
                stack.push(end);
            }else if(str.equals("D")){
                stack.push(2*stack.peek());
            }else if(str.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(str));
            }
        }
        int result = 0;
        for(int res : stack){
            result += (int) res;
        }
        return result;
    }