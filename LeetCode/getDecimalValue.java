 public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val);
            head = head.next;
        }
        double sum = 0;
        int length = sb.length();
        
        for(int i = 0; i < sb.length(); i++){
            sum += (sb.charAt(i) - '0') * Math.pow(2,length - 1);
            length--;
        }
        return (int)sum;
    }