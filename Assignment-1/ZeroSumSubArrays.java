/* Technique: variable-sized sliding window
 * This is because we have the different sized windows where we'll look at one 
 * pointer and then the second pointer will keep increasing until the end. 
 * 
 * Time and Space Complexity: O(n^2) because of the loop inside of the loop.
 */
public class ZeroSumSubArrays {
    public static int findZeroSumSubArrays(int[] array){
        if(array.length == 0|| array == null){
            return 0;
        }

        int count = 0;
        int runningTotal = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++){
            System.out.println("Starting Index: " + array[i]);
            runningTotal = 0;
            runningTotal += array[i];

            if(runningTotal == 0){
                System.out.println("------Added!------");
                count++;
            }

           for(int x = i+1; x< array.length; x++){
            runningTotal += array[x];
            System.out.println("Added Value: " + array[x] + ", Running Total: "+ runningTotal);

            if(runningTotal == 0){
                System.out.println("------Added!------");
                count++;
            }
           }
        }


        return count;
    }

    public static void main(String[] args){
        // int[] test1 = {4,5,2,-1,-3,-3,4,6,-7};
        // System.out.println("Test 1 Result : " + findZeroSumSubArrays(test1));

        // int[] test2 = {1,8,7,3,11,9};
        // System.out.println("Test 2 Result : " + findZeroSumSubArrays(test2));

        // int[] test3 = {8,-5,0,-2,3,4};
        // System.out.println("Test 3 Result : " + findZeroSumSubArrays(test3));

        int[] test4 = {4,3,3,5,7,0,2,3,8,0};
        System.out.println("Test 4 Result : " + findZeroSumSubArrays(test4));
    }
}
// This implementation took me around 15 minutes.
