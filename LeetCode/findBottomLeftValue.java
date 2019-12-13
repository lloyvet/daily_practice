public int findBottomLeftValue(TreeNode root) {
        return find(root,0);
    }
    int maxDepth = -1;
    int res = 0;
    public int find(TreeNode root,int depth){
        if(root == null)
            return 0;
        find(root.left,depth+1);
        if(depth>maxDepth){
            maxDepth = depth;
            res = root.val;
        }
        find(root.right,depth+1);
        return res;
    }