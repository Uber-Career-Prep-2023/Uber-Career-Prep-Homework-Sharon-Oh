/* Technique: Hash the Elements
 * I used the hash map to store each pair, and make it easier to look up for 
 * if there were very obvious overlapping pairs. 
 * 
 * Time and Space Complexity: O(2n) I use two for loops, but they are not nested
 * and they are independent of each other. 
 */
import java.util.*;
public class MergeIntervals {
    public static int[][] findMergeIntervals(int[][] pairs){

        if(pairs == null){
            return null;
        }
        //First Approach

        // ArrayList<Integer> sortedFront = new ArrayList<Integer>();
        // ArrayList<Integer> sortedBack = new ArrayList<Integer>();

        // int[][] mergedPairs = null;

        // //sorts
        // for(int row = 0; row < pairs.length; row++){
            
        //     int front = pairs[row][0];
        //     int back = pairs[row][1];
        //     int index = 0;
        //     for(; index < sortedFront.size(); index++){
        //         if(front < sortedFront.get(index)){
        //             continue;
        //         } else {
        //             break;
        //         }
        //     }

        //     sortedFront.add(index, front);
        //     sortedFront.add(index, back);
        // }

        
        // //creates the merge pairs
        // for(int r = 0; r < pairs.length; r++){
        //     int front = sortedFront.get(r);
        //     int back = sortedBack.get(r);
            
        //     int nextfront = Integer.MIN_VALUE;
        //     int nextback = Integer.MIN_VALUE;
        //     int index = r+1;

        //     while(index < pairs.length ){

        //         nextfront = pairs[index][0];
        //         nextback = pairs[index][1];
        //         if(index > r+1){
        //             sortedFront.remove(nextfront);
        //             sortedFront.remove(nextback);
        //         }
        //         index = index +1;
        //     }
        // }



        //Second Approach
        HashMap<Integer, Integer> newPairs = new HashMap<Integer, Integer>();

        for(int r = 0; r < pairs.length; r++){  
            int front = pairs[r][0];
            int back = pairs[r][1];

            if(newPairs.containsKey(front)){
                if(newPairs.get(front) < back){
                    newPairs.replace(front, back);
                }
            } else if (!newPairs.containsKey(front)){
                if(newPairs.containsKey(back)){ //problem with not checking if there are keys that are larger
                    int otherKeyBack = newPairs.get(back);
                    newPairs.remove(back);
                    newPairs.put(front, otherKeyBack);
                } else{
                   
                    newPairs.put(front, back);
                    
                }
            }
        }

        int[][] mergedPairs = new int[newPairs.size()][2];
        int toAdd = 0;
        for(Integer currKey : newPairs.keySet()){
            
            mergedPairs[toAdd][0] = currKey;
            mergedPairs[toAdd][1] = newPairs.get(currKey);
            toAdd++;
        }

        return mergedPairs;
        
    }

    public static void main(String[] args){
        int[][] test1 = {{2,3}, {4,8}, {1,2}, {5,7},{9,12}};
        System.out.println("Test 1 Result: ");
        toPrint(findMergeIntervals(test1));

        int[][] test2 = {{5,8}, {6,10}, {2,4}, {3,6}};
        System.out.println("Test 2 Result: " );
        toPrint(findMergeIntervals(test2));

        int[][] test3 = {{10,12}, {5,6}, {7,9}, {1,3}};
        System.out.println("Test 3 Result: " );
        toPrint(findMergeIntervals(test3));
    }

    public static void toPrint(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
// I used the whole 40 minutes but test case 2 wont work