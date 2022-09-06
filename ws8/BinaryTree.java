class Node<T>{
    T data;
    Node<T> left;
    Node<T> right;
    Node(T data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class BinaryTree<T> {
    Node<T> root;
    BinaryTree(){
        root=null;
    }
    void insertNode(T value){
        Node<T> n= new Node<T>(value);
        if (root==null){
            root=n;
        }
        while (root!=null) {
            if ((double) value >= (double) root.data) {
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
    }



}
