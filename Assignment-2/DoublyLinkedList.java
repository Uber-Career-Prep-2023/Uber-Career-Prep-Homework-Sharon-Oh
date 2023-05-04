// This implementation took around 30 minutes. 
// I wasn't sure how to test this, but in my head logically it should work.

public class DoublyLinkedList {

    // creates new Node with data val at front; returns new head
    public Node insertAtFront(Node head, int val){
        if(head == null){
            return new Node(val);
        }

        Node toAdd = new Node(val);
        toAdd.next = head;
        head.prev.next = toAdd;
        head.prev = toAdd;

        return toAdd;
    }

    // creates new Node with data val at end 
    public void insertAtBack(Node head, int val){
        if(head == null){
            head = new Node(val);
        }

        Node toAdd = new Node(val);
        Node lastNode = head.prev;
        head.prev = toAdd;
        lastNode.next = toAdd;
        toAdd.prev = lastNode;
        toAdd.next = head;

    }

    // creates new Node with data val after Node loc
    public void insertAfter(Node head, int val, Node loc){

        if(head == null){
            head = new Node(val);
        }
         else{
            Node curr = head;
            while(curr.data != loc.data && curr.next != head){
                curr = curr.next;
            }

            Node toAdd = new Node(val);
            if(curr.data == loc.data){

                //previous is the current node that matches location
                toAdd.prev = curr;

                //setting the next to be the curr node's next
                toAdd.next =curr.next;

                //changing the next node's previous location to be new node
                toAdd.next.prev = toAdd;

                //changing the current nodes next to be new node
                curr.next = toAdd;

            }


        }

    }

    // removes first Node; returns new head
    public Node deleteFront(Node head) {
        //if head is null or if there are no other next nodes
        if(head == null || head.next == null){
            return null;
        }

        Node prev = head.prev;
        Node next = head.next;

        next.prev = prev;
        prev.next = next;

        return next;
    }

    // removes last Node
    public void deleteBack(Node head) {
        //if head is null or if there are no other next nodes
        if(head != null){
            Node newLast = head.prev.prev;
            newLast.next = head; 
            head.prev = newLast;
        }
    }

    // deletes Node loc; returns head
    public Node deleteNode(Node head, Node loc){
        if(head == null){
            return null;
        }

        if(loc == head.prev){
            deleteBack(head);
            return head;
        } else if (loc == head){
            return deleteFront(head);
        } 
        
        Node prev = head.prev;
        Node curr = head;
        Node next = head.next;

        while(curr != loc && next != head){
            prev = curr;
            curr = next;
            next = next.next;
        }

        if (curr == loc){
            prev.next = next;
            next.prev = prev;
        }

        return head; //since we know its not gonna be the head
    }

    // returns length of the list
    public int length(Node head){
        if(head == null){
            return 0;
        } else if (head.next == null){
            return 1;
        }

        int count = 0;
        Node curr = head; 

        while(curr != null && curr.next != head){
            curr = curr.next;
            count++;
        }

        return count;
    }

    // reverses the linked list iteratively
    public Node reverseIterative(Node head){
        if(head == null){
            return null;
        }

        Node newHead = new Node (head.prev.data);
        Node curr = head.prev.prev;


        while (curr != newHead){
            insertAtBack(newHead, curr.data);
            curr = curr.prev;
        }

        return newHead;
    }

    // reverses the linked list recursively (Hint: you will need a helper function)
    public Node reverseRecursive(Node head) {
        return reverse(head, head.data);
    }

    public Node reverse(Node head, int headdata){
        if(head.next.data == headdata){
            Node oldPrev = head.prev;
            Node oldNext = head.next;

            head.prev = oldNext;
            head.next = oldPrev;

            return head;
        }

        Node oldPrev = head.prev;
        Node oldNext = head.next;

        head.next =  reverse(oldPrev, headdata);
        head.prev = oldNext;

        return head;

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

