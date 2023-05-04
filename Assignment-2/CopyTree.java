
public class CopyTree {

    //creating a new node will create a deep copy of the tree
    public Node copyTree(Node root) {
        if (root == null) {
            return null;
        }
        
        Node newRoot = new Node(root.data);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        
        return newRoot;
    }

    class Node {
        int data;
        Node left;
        Node right;
    
        Node(int d) {
            data = d;
        }
    }
}






