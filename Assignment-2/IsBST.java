public class IsBST {

    public boolean isBST(Node head){
        if(head.left == null && head.right == null){
            return true;
        }
        //if left node is  less than head
        if(head.left != null && head.left.data < head.data){

            if(isBST(head.left) == false){
                return false;
            }
        } else{ //if not 
            return false;
        }

        //if right node is greater than head 
        if(head.right != null && head.right.data > head.data){
            //call recursively on the right node and if false then return false
            if(isBST(head.right) == false){
                return false;
            }
        } else { //if not
            return false;
        }

        return false;
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

