public int maxDepth(TreeNode root) {
        int max = -1;
        if(root==null)
            return 0;
        if(root.right==null&&root.left==null)
            return 1;
        if(root.right!=null)
            max = Math.max(max,maxDepth(root.right));
        if(root.left!=null)
            max = Math.max(max,maxDepth(root.left));
        return max+1;
    }