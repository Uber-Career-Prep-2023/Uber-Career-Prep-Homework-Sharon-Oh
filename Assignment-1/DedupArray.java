/*  Technique: One directional running computation/total,
 * this is because I traverse the loop the same way approximately three times
 * so that I can first identify all the unique elements, then set the value, and
 * finally print the list out. 
 * 
 * I'm not sure if printing the list out counts, if it does not then O(2n)
 * 
 * Time and Space Complexity: O(3n) because there are three loops but they're
 * loop within each other.
 */
import java.util.*;
public class DedupArray {
    
    public int[] findDedupArray(int[] array){
        ArrayList<Integer> uniqueElements = new ArrayList<Integer>();

        if(array.length == 0 || array.length == 1 || array == null){
            return array;
        } 

        for(int i = 0; i < array.length; i++){
            if(!uniqueElements.contains(array[i])){
                uniqueElements.add(array[i]);
            }
        }

        int counter = 0;
        for( int x = 0; x < array.length; x++){
            if(counter < uniqueElements.size()){
                array[x] = uniqueElements.get(counter);
                counter++;
            } else {
                array[x] = -1;
            }
        }
        return array;
    }

    public static void main(String[] args){
        DedupArray test = new DedupArray();

        int[] test1 = {1,2,2,3,3,3,4,4,4,4};
        int[] returnArray1 = test.findDedupArray(test1);
        System.out.println("Test 1: ");
        for(int j = 0; j < returnArray1.length; j++){
            System.out.print(returnArray1[j]+" ");
        }
        System.out.println();

        int[] test2 = {0,0,1,4,5,5,5,8,9,9,10,11,15,15};
        int[] returnArray2 = test.findDedupArray(test2);

        System.out.println("Test 2: ");
        for(int j = 0; j < returnArray2.length; j++){
            System.out.print(returnArray2[j]+" ");
        }
        System.out.println();

        int[] test3 = {1,3,4,8,10,12};
        int[] returnArray3 = test.findDedupArray(test3);
       
        System.out.println("Test 3: ");
        for(int j = 0; j < returnArray3.length; j++){
            System.out.print(returnArray3[j]+" ");
        }
        System.out.println();
    }

}

//This took me 13 minutes