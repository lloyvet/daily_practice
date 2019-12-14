public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        add(root,arr);
        TreeNode res = new TreeNode(arr.get(0));
        TreeNode temp = res;
        for(int i = 1; i < arr.size(); i++){
            temp.right = new TreeNode(arr.get(i));
            temp = temp.right;
        }
        return res;
    }
    
    public void add(TreeNode root,ArrayList<Integer> arr){
        if(root == null)
            return;
        add(root.left,arr);
        arr.add(root.val);
        add(root.right,arr);
    }