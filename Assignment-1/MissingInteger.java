/* Technique: Sort then Solve
 * Except it is already sorted! I solved it by iterating through the list, to
 * find when it isn't equal to each other. 
 * 
 * Time & Space Complexity: O(n) -> worst case we wouldve looked thorugh all the
 * elements in the list
 */
public class MissingInteger {
    public static int findMissingInteger(int[] array, int n){
        int counter = 1;

        for(int i = 0; i < array.length; i ++){
            if(array[i] != counter){
                return counter;
            } else {
                counter = counter +1;
            }
        }
        return counter;
    }

    public static void main(String[] args){

        int[] test1 = {1, 2, 3, 4, 6, 7};
        int n1 = 7;
        System.out.println("Test 1: " + findMissingInteger(test1, n1));

        int[] test2 = {1};
        int n2 = 2;
        System.out.println("Test 2: " + findMissingInteger(test2, n2));

        int[] test3 = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12};
        int n3 = 12;
        System.out.println("Test 3: " + findMissingInteger(test3, n3));

        int[] test4 = {1,2,3,4,5,6,7,8,10,11,12,13,14,15,16};
        int n4 = 16;
        System.out.println("Test 4: " + findMissingInteger(test4, n4));

    }
}

//This code took me around 7 minutes 