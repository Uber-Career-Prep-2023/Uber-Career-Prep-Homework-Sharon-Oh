/* Type of Problem: Heap 
 * i didn't finish, but wherever that used the heapify method (insert and 
 * preferably delete), it would need to be O(n^2) im assuming because we call 
 * a lot of add and delete operations  but space would be 
 * technically around O(n) because we have that list  
 */
import java.util.*;
public class Heap {

    private ArrayList<Integer> list;

    public Heap(){
        list = new ArrayList<Integer>();
    }

    public int top(){
        return list.get(0);
    }

    // this would take the time complexity of the heap problem originally 
    public void insert(Integer x){
        list.add(0, x);
        if(list.size() > 1){
            heapify();
        }
        
    }

    //printing helper method 
    public void print(){
        for(int i = 0; i < list.size(); i++){
            System.out.println(i+": "+list.get(i));
        }
    }

    // this would have to be changed to work with heaping again since we dont 
    // know if the element that we add to the top is the correct place 
    public void remove(){
        if(list.size() == 0){
            return;
        }

        list.remove(0);
        Integer curr = list.get(list.size()-1);
        list.add(0, curr);
    }

    private void heapify(){

        int currHead = list.get(0);
        System.out.println("New Element: " +currHead);
        int currindex =  list.size()-1;
        int i = 0;

        //if even number of elements
        if(list.size()%2 == 0){
            i = list.size()-1;
        } else {
            i = list.size()-2;
        }

        System.out.println("currHead < "+ list.get(i) + ": " + (currHead < list.get(i)));

        while((i >= 0 && currindex >= 0) && currHead < list.get(i)){
            
            int temp = list.get(i);
            int curr = list.get(currindex);
            list.remove(i);
            list.remove(currindex);

            list.add(i, curr);
            list.add(currindex, temp);
            
            currindex = i;

            i = i - 2;
        }

        if(i < 0 && currHead < list.get(0)){
            int temp = list.get(0);
            list.remove(0);
            list.add(currHead, 0);
            list.remove(currindex);
            list.add(temp, currindex);
        }
    }

    public static void main(String[] args){
        Heap example = new Heap();
        example.insert(new Integer(3));
        example.insert(new Integer(2));
        example.insert(new Integer(5));
        example.print();
    }
}

/* Ended up not working with adding and then making sure that the order is 5,3,2
 * 
 */