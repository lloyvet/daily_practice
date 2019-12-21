TreeNode temp;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        add(root);
        return min;
    }
    
    public void add(TreeNode root){
        if(root == null)
            return;
        add(root.left);
        if(temp!=null){
            min = Math.abs(Math.min(min,root.val-temp.val));
        }
        temp = root;
        add(root.right);
    }