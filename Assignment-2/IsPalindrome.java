public class IsPalindrome {

    public boolean isPalindrome(Node head){
        if (head.next == null){
            return true;
        }

        if (head.data != head.prev.data){
            return false;
        }


        Node forwards = head;
        head.data = -1;
        Node backwards = head.prev.prev;
        while(backwards.data != head.data){
            if(backwards.data != forwards.data){
                return false;
            } 
            forwards = forwards.next;
            backwards = backwards.prev;
        }
    
        return true;
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
