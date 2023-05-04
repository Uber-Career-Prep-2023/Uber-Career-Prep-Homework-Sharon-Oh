import java.util.*;

public class DedUpSortedList {

    public Node getDedUpSortedList(Node head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();

        return getNodeAux(head,list);
    }

    public Node getNodeAux (Node head, ArrayList<Integer>list){
        if(list.contains(head.data) == true){
            return head.next;
        }

        list.add(head.data);

        head.next = (getNodeAux(head.next, list));

        return head;
    }

    class Node {
        int data;
        Node next;
    
        Node(int d) {
            data = d;
        }
    }
}
