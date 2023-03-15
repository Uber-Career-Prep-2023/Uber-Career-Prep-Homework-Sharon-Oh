/* Technique : Variable-size (shrinking/growing sliding window)
 * This technique I traversed through the array forwards
 * but in that in one loop i looked at one element and then in an inner loop, 
 * i traversed and looked at the elements after this current element to the end of the array. 
 * 
 * This program uses O(n^2) because we have two loops that are looking at n elements which is the 
 * worst case.
 */


public class TwoSum {
    public int findTwoSum(int[] array, int k){
        int numPairs = 0;

        if(array.length == 0 || array == null){
            return 0;
        }

        for (int forward = 0; forward < array.length; forward++){
            for (int backward = forward + 1; backward < array.length; backward++){
                int sum = array[forward] + array[backward];

                if(sum == k){
                    numPairs++;
                }
            }
        }

        return numPairs;
    }

    public static void main(String[] args){
        TwoSum test = new TwoSum();
        int[] test1 = {1,10,8,3,2,5,7,2,-2,-1};
        int k1 = 10;
        System.out.println("Test 1 Result : " + test.findTwoSum(test1, k1));

        int[] test2 = {1,10,8,3,2,5,7,2,-2,-1};
        int k2 = 9;
        System.out.println("Test 2 Result : " + test.findTwoSum(test2, k2));

        int[] test3 = {4,3,3,5,7,0,2,3,8,6};
        int k3 = 6;
        System.out.println("Test 3 Result : " + test.findTwoSum(test3, k3));

        int[] test4 = {4,3,3,5,7,0,2,3,8,6};
        int k4 = 1;
        System.out.println("Test 4 Result : " + test.findTwoSum(test4, k4));
    }
}

// This code took me 15 minutes
