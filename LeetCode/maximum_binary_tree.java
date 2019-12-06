public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        int n = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(findMax(nums) == nums[i])
                n = i;
        }
        if(nums.length == 0)
            return null;
        TreeNode node = new TreeNode(findMax(nums));
        int[] leftArray = Arrays.copyOfRange(nums, 0, n);
        int[] rightArray = Arrays.copyOfRange(nums, n + 1, nums.length);
        node.left = constructMaximumBinaryTree(leftArray);
        node.right = constructMaximumBinaryTree(rightArray);
        return node;
    }
    
    public int findMax(int[] nums){
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(max<nums[i])
                max = nums[i];
        }
        return max;
    }