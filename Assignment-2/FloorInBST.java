public class FloorInBST{
    
    public int findFloor(Node root, int target) {
        int floor = Integer.MIN_VALUE;
        
        Node curr = root;

        //continue looking at the tree until we reach the smallest node or the correct node
        while (curr != null) {
            if (curr.data == target) {
                return curr.data;
            } else if (curr.data < target) {
                floor = curr.data;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return floor;
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