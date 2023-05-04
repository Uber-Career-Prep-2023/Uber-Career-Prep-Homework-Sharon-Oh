// This took me the entire 40 minutes, I was having trouble with deciding about 
// how to implement the delete method

public class BinarySearchTree {
    
    // returns the minimum value in the BST
    public int min(Node head){
        if(head.left == null){
            return head.data;
        }

        return min(head.left);

    }

    // returns the maximum value in the BST
    public int max(Node head){
        if(head.right == null){
            return head.data;
        }

        return max(head.right);
    }

    // returns a boolean indicating whether val is present in the BST
    public boolean contains(Node head, int val){
        if (head.data == val){
            return true;
        }
        if(head.left == null|| head.right == null){
            return false;
        }

        if(head.data > val){
            return contains(head.left, val);
        }

        return contains(head.right, val);

    }

    // For simplicity, do not allow duplicates. If val is already present, insert is a no-op

    // creates a new Node with data val in the appropriate location
    public void insert(Node head, int val) {
        if(contains(head, val) == false){
            head = insertAux(head, val);
        }
    }

    public Node insertAux(Node head, int val){
       if(head == null){
            return new Node(val);
       }
       
        else if(head.right.data > val){
            head.left = insertAux(head.left, val);
        }

        else if(head.left.data < val){
            head.right = insertAux(head.right, val);
        }

        return head;
    }


    // deletes the Node with data val, if it exists
    public int delete(Node head, int val) {
        if(contains(head, val) == true){
            head = deleteAux(head, null, val);
            if(contains(head,val) == true){
                return -1;
            } else {
                return 0;
            }
        }
        return -1; //since the node doesn't exist
    }

    //with the way i was tryign to implement this, it would have been 
    // complicated implementing the other parts whether there are both children 
    // several nodes after finding the correct node to delete. 
    private Node deleteAux(Node head, Node prev, int val){
        if(head.right.data == val){
            if(head.right.left != null && head.right.right == null){
                head.right = head.right.left;
            } else if (head.right.left == null && head.right.right != null){
                head.right = head.right.right;
            } else {

            }
        }
        return head;
    }

    class Node{
        public int data; 
        public Node left; 
        public Node right; 

        public Node ( int d){
            data = d;
            left = null;
            right = null;
        }
    }
}
