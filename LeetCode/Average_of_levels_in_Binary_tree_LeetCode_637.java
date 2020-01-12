/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        //
        List<Double> res = new ArrayList<>();
        List<TreeNode> tree = new LinkedList<>();
        if(root == null)
            return null;
        tree.add(root);
        while(!tree.isEmpty()){
            int size = tree.size();
            double sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = tree.remove(0);
                sum += node.val;
                if(node.left!=null)
                    tree.add(node.left);
                if(node.right!=null)
                    tree.add(node.right);
            }
            res.add(sum / size);
        }
        return res;
        
    }
}
