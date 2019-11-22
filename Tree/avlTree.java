package AvlTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10,11,7,6,8,9};
        //创建avl树
        AVLTree avl = new AVLTree();
        for(int i = 0; i < arr.length; i++){
            avl.add(new Node(arr[i]));
        }
        avl.midShow();
        System.out.println();
        System.out.println(avl.getRoot().height());
        System.out.println(avl.getRoot().leftHeight());
        System.out.println(avl.getRoot().rightHeight());
        System.out.println(avl.getRoot());
        avl.midShow();
    }
}
class AVLTree{
    private Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }
    public void midShow(){
        if(root!=null)
            root.midShow();
    }
    public void preShow(){
        if(root!=null)
            root.preShow();
    }

    public Node getRoot() {

        return root;
    }
    public  Node search(int value){
        if(root == null)
            return  null;
        else
            return root.search(value);
    }
    public  Node searchParent(int value){
        if(root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }
    /*
    node 传入的结点（当bst的根结点）
    返回以node为根结点bst最小结点的值
     */
    public  int delRightTreeMin(Node node){
        Node target = node;
        //循环的查找左节点找到最小值
        while(target.left != null){
            target = target.left;
        }
        //target指向最小结点
        //删除最小结点
        deleteNode(target.value);
        return target.value;
    }
    public void deleteNode(int value){
        if(root == null){
            return;
        }else{
            Node targetNode = search(value);
            //如果没有找到删除的结点
            if (targetNode == null){
                return;
            }
            //如果targetNode没有父节点直接删除此树
            if(root.left==null&&root.right==null){
                root = null;
                return;
            }
            //去找打targetNode的父节点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if(targetNode.left==null && targetNode.right==null){
                if(parent.right!=null&&parent.right.value==value) {
                    parent.right = null;
                }else if(parent.left!=null&&parent.left.value == value){
                    parent.left = null;
                }
            } else if (targetNode.left!=null&&targetNode.right!=null) {//删除有两颗子树的结点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else{//删除只有一棵子树的结点
                //如果删除的结点有左子节点
                if(targetNode.left!=null){
                    if(parent!=null) {
                        //如果targetNode是parent左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                }else{
                    //删除的结点有右子节点
                    //如果targe是parent的左子节点
                    if(parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            //右子节点
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }
                }

            }
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {

        this.value = value;
    }
    //返回左子树的高度
    public  int leftHeight(){
        if(left == null){
            return  0;
        }
        return  left.height();
    }
    //返回右子树的高度
    public  int rightHeight(){
        if(right == null){
            return  0;
        }
        return  right.height();
    }
    //返回当前结点为根结点树的高度
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height())+1;
    }
    //左旋转方法
    private void leftRotate(){
        //创建新的结点，当前根结点的值
        Node newNode = new Node(value);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = left;
        //把新的结点右子树设置成当前结点的右子树的左子树
        newNode.right = right.left;
        //把当前结点的值换成右子结点的值
        value = right.value;
        //把当前结点的右子树设置成右子树的右子树
        right = right.right;
        //把当前结点的左子节点设置成新的结点
        left = newNode;
    }
    //右旋转方法
    private void rightRotate(){
        //创建新的结点，当前根结点的值
        Node newNode = new Node(value);
        //把新的结点的右子树设置为当前结点的右子树
        newNode.right = right;
        //把新的结点的左子树设置成当前结点左子树的右子树
        newNode.left = left.right;
        //把当前结点的值设置成左子节点的值
        value = left.value;
        //把当前结点的左子树设置成左子树的左子树
        left = left.left;
        //把当前结点的右子结点设置成新的结点
        right = newNode;

    }
    

    //添加结点
    public void add(Node node){
        if(node == null)
            return;
        //判断传入结点和当前子树根结点的关系
        if(node.value < this.value){
            //如果当前结点左子树为空直接添加
            if(this.left == null){
                this.left = node;
            }else{
                //递归向左子树添加
                this.left.add(node);
            }
        }else {//添加的结点的值大于当前结点的值
            if(this.right == null){
                this.right = node;
            }else {
                //递归向右子树添加
                this.right.add(node);
            }
        }
        //当添加完结点后如果右子树的高度-左子树的高度>1左旋转
        if(rightHeight()-leftHeight()>1){
            //如果它的右子树的左子树的高度大于它右子树的高度
            if(this.right!=null&&this.right.leftHeight()>this.right.rightHeight()){
                //先对当前结点的右子节点进行右旋转
                this.right.rightRotate();
                leftRotate();
            }else
           leftRotate();//左旋转
            return;
        }else if(leftHeight() - rightHeight() > 1){
            //如果它的左子树的右子树高度大于它左子树的高度
            if(this.left!=null&&this.left.rightHeight()>this.left.leftHeight()){
                //先对当前结点的左节点进行左旋转
                this.left.leftRotate();
                rightRotate();
            }else
            rightRotate();

        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //中序遍历
    public void midShow(){
        if(this.left!=null){
            this.left.midShow();
        }
        System.out.print(this.value+" ");
        if(this.right != null){
            this.right.midShow();
        }
    }
    //前序遍历
    public void preShow(){
        System.out.print(this.value+" ");
        if(this.left!=null){
            this.left.preShow();
        }
        if(this.right!=null){
            this.right.preShow();
        }
    }

    //查找要删除的结点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            //如果左子节点为空
            if (this.left == null)
                return null;
            return this.left.search(value);
        } else {
            if (this.right == null)
                return null;
            return this.right.search(value);
        }
    }
    //查找要删除节点的父节点
    public Node searchParent(int value){
        if((this.left != null && this.left.value == value)||
                (this.right != null &&this.right.value == value)){
            return this;
        }else{
            //如果查找的值小于当前结点，并且当前结点左子节点不为空
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);//向左递归查找
            }else if(value >= this.value && this.right !=null){
                return  this.right.searchParent(value); //向右递归查找
            }else{
                return null; //没有找到父节点
            }
            
        }
    }
}