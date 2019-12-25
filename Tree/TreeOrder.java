//二叉树非递归遍历
//前序遍历
 public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while(temp!=null||!stack.isEmpty()){
            while(temp!=null){
                res.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            temp = temp.right;
        }
        return res;
    }
//中序遍历
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp !=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }

