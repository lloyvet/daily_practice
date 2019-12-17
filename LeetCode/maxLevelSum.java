public int maxLevelSum(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        int v = 0;
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove(0);
                sum += node.val;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            if(sum > max){
                max = (int)sum;
                v = count;
            }
            count++;
        }
        return v;
    }