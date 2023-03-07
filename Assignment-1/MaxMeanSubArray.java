/* Technique: Two Pointer Technique
 * Time and Space Complexity: O(n^2) because of the loop inside of the loop, in 
 * the worst case it will both run for the length of all the array elements. And since
 * one loop is O(n) and the other one is inside, it will be O(n)*O(n).
 */

 public class MaxMeanSubArray {

    public double findMaxMeanSubArray(int[] array, int k){
        double result = 0.0; 
        double tempTotal = 0;


        // not sure what to do with the edge cases when array length is 0 or 1 
        if (array.length == 0 || array.length == 1){
            return 0;
        } 
        // outer loop that looks through the array once
        for (int i = 0; i < array.length; i++){
            tempTotal += array[i];

            // inner loop that runs k times 
            for (int x = i + 1; x < k + i + 1; x++){
                if (x >= array.length){
                    break;
                } 
                tempTotal += array[x];
            }

            tempTotal = tempTotal/k;

            //this is when i check if its the largest average of the subarrays
            if(tempTotal > result){
                result = tempTotal;
            }

            tempTotal = 0;
        }
        return result;
    }
    
    public static void main(String[] args){
        MaxMeanSubArray test = new MaxMeanSubArray();
        int[] test1 = {4,5,-3,2,6,1};
        int k1 = 2;
        System.out.println("Test 1 Result : " + test.findMaxMeanSubArray(test1, k1));

        int[] test2 = {4,5,-3,2,6,1};
        int k2 = 3;
        System.out.println("Test 2 Result : " + test.findMaxMeanSubArray(test2, k2));

        int[] test3 = {1,1,1,1,-1,-1,2,-1,-1};
        int k3 = 3;
        System.out.println("Test 3 Result : " + test.findMaxMeanSubArray(test3, k3));

        int[] test4 = {1,1,1,1,-1,-1,2,-1,-1, 6};
        int k4 = 5;
        System.out.println("Test 2 Result : " + test.findMaxMeanSubArray(test4, k4));
    }
}

/* Around 35 Minutes but I had to debug using the environment (close and reopen) */