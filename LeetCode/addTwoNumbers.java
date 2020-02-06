public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode dummy = null;
        ListNode n1 = l1;
        int cont1 = 0;
        while(n1 != null){
            st1.push(n1.val);
            n1 = n1.next;
            cont1++;
        }
        ListNode n2 = l2;
        int cont2 = 0;
        while(n2 != null){
            st2.push(n2.val);
            n2 = n2.next;
            cont2 ++;
        }
       
        int value = 0;   
        while(!st1.isEmpty()||!st2.isEmpty()||value != 0){
           
            if(!st1.isEmpty()){
                value += st1.pop();
            }
            if(!st2.isEmpty()){
                value += st2.pop();
            }
            ListNode cur = new ListNode(value %10);
            value /= 10;
            cur.next = dummy;
            dummy = cur;
        }
        return dummy;
    }