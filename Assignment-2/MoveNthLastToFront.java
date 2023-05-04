

public class MoveNthLastToFront {
    public Node moveNthLastToFront(Node head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        
        //should be sorted in order
        Node curr = head; 
        while(curr != null){
            Node temp = curr;
            while(temp.data > temp.next.data){
                curr.next  = temp; 
                curr = temp.next;
                curr.next.next = temp.next.next;
            }
            curr = curr.next; 
        }

        //traverses until the nth last element if found
        Node preElement = null;
        Node element = head;
        while(element != null && n > 0){
            preElement = curr;
            curr = curr.next;
            n--;
        }

        //rearranges the head to be in the front
        preElement.next = element.next;
        element.next = head; 

        return element;
    }

    class Node { 
    
        int data; 
        Node prev;
        Node next; 

        // Constructor 
        Node(int d) 
        { 
            data = d; 
            prev = null;
            next = null; 
        } 
    }
}
