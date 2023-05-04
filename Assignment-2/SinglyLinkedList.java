// This implementation took around 40 minutes. 
// I wasn't sure how to test this, but in my head logically it should work.

public class SinglyLinkedList {

    // creates new Node with data val at front; returns new head
    public Node insertAtFront(Node head, int val){
        if(head == null){
            return new Node(val);
        }

        //created to keep track
        Node oldHead = head; 

        //created to start the new linkedlist
        Node newHead = new Node(val);
        newHead.next = oldHead;

        return newHead;
    }

    // creates new Node with data val at end 
    public void insertAtBack(Node head, int val){
        if(head == null){
            head = new Node(val);
        } else {

            //continues searching for the next empty space after a node in order to 
            //insert into the linkedlist
            Node curr = head; 
            while(curr.next != null){
                curr = curr.next;
            }

            curr.next = new Node(val);
        }

    }

    // creates new Node with data val after Node loc
    public void insertAfter(Node head, int val, Node loc){

        if(head == null){
            head = new Node(val);
        }

        Node curr = head;
        while(curr != null && curr.data != loc.data){
            curr = curr.next;
        }

        Node oldNext = curr.next;
        Node newNext = new Node(val);
        if(curr.data == loc.data){
            curr.next = newNext;
            newNext.next = oldNext;
        }

    }

    // removes first Node; returns new head
    public Node deleteFront(Node head) {
        //if head is null or if there are no other next nodes
        if(head == null || head.next == null){
            return null;
        }

        Node currNext = head.next;
        head.next = null;

        return currNext;
    }

    // removes last Node
    public void deleteBack(Node head) {
        //if head is null or if there are no other next nodes
        if(head != null){
            Node curr = head;
            Node currNext = head.next;
            while(currNext != null){
                curr = currNext;
                currNext = currNext.next;
            }

            curr.next = null;

        }
    }

    // deletes Node loc; returns head
    public Node deleteNode(Node head, Node loc){
        if(head == null){
            return null;
        }

    //now that i look back at this method, i could have made it simpler by 
    //calling remove end or front
    
        Node curr = head; 
        Node prev = null;
        Node currNext = curr.next;

        while(curr != null && curr.data != loc.data){
            prev = curr;
            curr = currNext;
            currNext = currNext.next;
        }

        if(curr.data == loc.data){
            prev.next = currNext;
        }

        return head;
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

        while(curr != null){
            curr = curr.next;
            count++;
        }

        return count;
    }

    // reverses the linked list iteratively
    public Node reverseIterative(Node head){
        if(head == null){
            return null;
        } else if (head.next == null){
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        while(curr != null){

            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;

        }

        return curr;
    }

    // reverses the linked list recursively (Hint: you will need a helper function)
    public Node reverseRecursive(Node head) {
        return reverse(head);
    }

    public Node reverse(Node head){
        if(head.next == null){
            return head;
        }
        
        head.next = reverse(head.next);

        return head;
    }

    //taken from geeks4geeks
    class Node { 
    
        int data; 
        Node next; 

        // Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    }

    // public void printNodes(Node head){
    //     Node curr = head; 

    //     while(curr !=  null){
    //         System.out.println(curr.data + "\t");
    //     }
    // }

    // public static void main(String[] args){
    //     SinglyLinkedList test1 = new SinglyLinkedList();
    //     test1.printNodes(test1.insertAtFront(null, 8));
    //     test1.printNodes(test1.insertAtFront(new Node(0),19));


    //     test1.printNodes(test1.insertAtFront(new Node(10), 25));
    //     Node testNode1 = new Node (2);
    //     testNode1.next = new Node(5);
    //     test1.printNodes(test1.insertAtFront(testNode1, 3));
    // } 

}

