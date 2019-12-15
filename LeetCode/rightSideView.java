HashMap<Integer,Integer> map = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int maxDepth = -1;
        nodeStack.push(root);
        depthStack.push(0);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if(node!=null){
            maxDepth = Math.max(maxDepth,depth);
            if(!map.containsKey(depth)){
                map.put(depth,node.val);
                }
            nodeStack.push(node.left);
            nodeStack.push(node.right);
            depthStack.push(depth+1);
            depthStack.push(depth+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= maxDepth; i++){
            list.add(map.get(i)); 
        }
        return list;
        
    }