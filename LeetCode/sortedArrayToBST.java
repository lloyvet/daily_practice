public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums,0,nums.length-1);
    }
    TreeNode BST(int[] nums, int left, int right){
        if(left > right)
            return null;
        int mid = (int)(left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums,left,mid-1);
        root.right = BST(nums,mid+1,right);
        return root;
        
    }