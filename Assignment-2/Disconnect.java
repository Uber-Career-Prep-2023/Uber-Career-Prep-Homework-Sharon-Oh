import java.util.*;
public class Disconnect {
    
    public Node disconnect(Node head){
        HashMap<Integer, Integer> transitions = new HashMap<Integer, Integer>();

        Node prev = null;
        Node curr = head;
        boolean lookedAtNode = false;
        while(!lookedAtNode){
            if(transitions.containsKey(curr.data) == false){
                transitions.put(curr.data, curr.next.data);
                prev = curr;
                curr = curr.next;
            }else{
                if(transitions.get(curr.data) == curr.next.data){
                    lookedAtNode = true;
                    prev.next = null;
                } else{
                    transitions.put(curr.data, curr.next.data);
                    prev = curr;
                    curr = curr.next;
                }
            }
        }
        return curr;
    }

    class Node {
        int data;
        Node next;
    
        Node(int d) {
            data = d;
        }
    }
}
