/* I used all the given time, 
 * but now that I think about it, it would make sense to use a queue or other 
 * data structure to be able to add more data as binary numbers are kind of like
 *  a system where you contantly keep adding onto alrewady existing data
 * 
 * In this problem we would have had to use a queue! 
 */
import java.util.*;
public class FirstKBinaryNumbers {
    public ArrayList<String> getFirstKBinaryNumbers(int k){
        // if we can assume that the number isn't going to be negative 
        if(k < 0){
            return new ArrayList<String>();
        }

        ArrayList<String> list = new ArrayList<String>();

        int counter = 0;
        int currNum = 0;
        String currString = "";

        // constantly adding to the list until we hit k iterations 
        while(counter <= k){

            //creates the two different strings that append 0 and 1 
            String toAdd0 = "0" + currString;
            String toAdd1 = "1" + currString;

            list.add(toAdd0);
            
            currString = list.get(currNum);

            //increment counter, and then still check if it is valid 
            counter++;
            if(counter <=k){
                list.add(toAdd1);
                currNum++; 
            }
        }

        return list;
    }

    // helper method 
    public void print(ArrayList<String> list){
        System.out.print("[");
        for(String curr: list){
            System.out.print(" " +curr + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        FirstKBinaryNumbers test = new FirstKBinaryNumbers();
        test.print(test.getFirstKBinaryNumbers(0));
        test.print(test.getFirstKBinaryNumbers(1));
        test.print(test.getFirstKBinaryNumbers(2));
        test.print(test.getFirstKBinaryNumbers(3));
        test.print(test.getFirstKBinaryNumbers(4));
        test.print(test.getFirstKBinaryNumbers(5));

    }
}
 
