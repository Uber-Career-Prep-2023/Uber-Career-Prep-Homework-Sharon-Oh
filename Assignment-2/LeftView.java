// Had trouble trying to implement. I used all the time.
import java.util.*;

public class LeftView {
    
    public ArrayList<Integer> LeftView(Node head){
        if (head == null){
            return new ArrayList<Integer>();
        }
        Node curr = leftViewAux(head);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(curr != null){
            curr = curr.left;
            list.add(curr.data);

            curr = curr.right; 
            list.add(curr.data);

        }

        return list;
    }

    // private int countLevel(Node head){
    //     if(head == null){
    //         return 0;
    //     }

    //     if(head.left != null){
    //         return 
    //     }
    // }

    //tried to figure out a way to get rid of the other variables (children)
    private Node leftViewAux (Node head){
        if(head == null){
            return null;
        }
        if(head.left != null){
            head.left = leftViewAux(head.left);
        }
        else if(head.left == null){
            head.right = leftViewAux(head.right); 
        }

        return head;
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
