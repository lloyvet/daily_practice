class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root.left!=null){
            getNum(root,root.left,root.left.left);
            getNum(root,root.left,root.left.right);
        }
        if(root.right!=null){
            getNum(root,root.right,root.right.left);
            getNum(root,root.right,root.right.right);
        }
        return num;
    }
    int num = 0;
    public void getNum(TreeNode root,TreeNode parent,TreeNode self){
            if(self==null||parent==null)
                return ; 
            if(root.val%2==0){
                num += self.val;
            }
            getNum(parent,self,self.left);
            getNum(parent,self,self.right);
        
    }
    /*
    if(root.left!=null&&root.left.right!=null&&root.val%2==0){
            num += root.left.right.val;
            getNum(root.left);
        }
        if(root.left!=null&&root.val%2==0&&root.left.left!=null){
            num += root.left.left.val;
            getNum(root.left);
        }
        if(root.right!=null&&root.right.right!=null&&root.val%2==0){
            num += root.right.right.val;
            getNum(root.right);
        }
        if(root.right!=null&&root.val%2==0&&root.right.left!=null){
            num += root.right.left.val;
            getNum(root.right);
        }*/
}