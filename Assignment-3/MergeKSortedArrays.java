/*
* Some ways I was thinking about doing this question:
* to go through every number avaliable and then if its in the array and 
* then add it into the array lol, but thats not logical
*
* This one uses a priority queue to sort the array elements in terms of the values. 
* This would be O(3n) because we have three loops, and then the space would be O(n) because the priority queue
* but my only concern would be the ArrayElement inner class but since it does not have any actions 
* like methods, i think it would be fine in terms of space. 
*/

import java.util.*;

public class MergeKSortedArrays {
    public ArrayList<Integer> mergeArrays(int k, int[][] arrays) {
        PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>();
        
        // Initialize the min heap with the first element from each array
        for (int i = 0; i < k; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new ArrayElement(arrays[i][0], i, 0));
            }
        }
        
        List<Integer> mergedList = new ArrayList<>();
        
        // Merge the arrays by repeatedly extracting the minimum element from the min heap
        while (!minHeap.isEmpty()) {
            ArrayElement minElement = minHeap.poll();
            mergedList.add(minElement.value);
            
            int arrayIndex = minElement.arrayIndex;
            int nextIndex = minElement.nextIndex + 1;
            
            // Check if there are more elements in the current array
            if (nextIndex < arrays[arrayIndex].length) {
                minHeap.offer(new ArrayElement(arrays[arrayIndex][nextIndex], arrayIndex, nextIndex));
            }
        }
        
        // Convert the merged list to an array
        ArrayList<Integer> toReturn = new ArrayList<>();
        for (int i = 0; i < mergedList.size(); i++) {
            toReturn.add(mergedList.get(i));
        }
        
        return toReturn;
    }

    class ArrayElement implements Comparable<ArrayElement> {
        int value;
        int arrayIndex;
        int nextIndex;
        
        ArrayElement(int value, int arrayIndex, int nextIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.nextIndex = nextIndex;
        }
        
        public int compareTo(ArrayElement other) {
            return this.value - other.value;
        }
    
    }

    public void print(ArrayList<Integer> list){
        System.out.print("[ ");
        for(Integer curr: list){
            System.out.print(curr + " ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        MergeKSortedArrays test = new MergeKSortedArrays();

        int[][] arrays1 = { {1, 2, 3, 4, 5}, {1, 3, 5, 7, 9} };
        test.print(test.mergeArrays(2, arrays1));

        int[][] arrays2 = { {1, 4, 7, 9}, {2, 6, 7, 10, 11, 13, 15}, {3, 8, 12, 13, 16} };
        test.print(test.mergeArrays(3, arrays2));
    }
}

