/*  Technique: Two array pointers 
 * I used two different pointers to navigate through both of the words. 
 * 
 * Time and space complexity:O(3n)
 * I know that it isn't the best, but it works :D and my implementation is definitely more messy.
 */
import java.util.*;
public class KAnagrams {
    public static boolean findKAnagrams(String input1, String input2, int k){
        HashMap<Character,Integer> input1letters = new HashMap<Character,Integer>();
        HashMap<Character,Integer> input2letters = new HashMap<Character,Integer>();
        HashMap<Character,Integer> input1temp = new HashMap<Character,Integer>();

        if(Math.abs((input1.length() - input2.length())) > k || input1 == null || input2 == null){
            return false;
        }    
        
        int counter = 0;

        //goes through and adds each letter in the maps respectively
        while( counter < input1.length() || counter < input2.length()){
            if(counter < input1.length()){
                char curr = input1.charAt(counter);
                if(!input1letters.containsKey(curr)){
                    input1letters.put(curr, 1);
                    input1temp.put(curr, 1);
                } else{
                    int num = input1letters.get(curr);
                    num = num +1;
                    input1letters.replace(curr, (num));
                    input1temp.replace(curr, num);
                }
            }

            if(counter < input2.length()){
                char curr = input2.charAt(counter);
                if(!input2letters.containsKey(curr)){
                    input2letters.put(curr, 1);
                } else{
                    int num = input2letters.get(curr);
                    num = num +1;
                    input2letters.replace(curr, (num));
                }
            }

            counter ++;
        }

        int numDiff = 0; 

        //goes through and compares one map to the other
        for(Character currKey : input1temp.keySet()){
            if(input2letters.containsKey(currKey)){
                int val1 = input1letters.get(currKey);
                int val2 = input2letters.get(currKey);

                if ((val1-val2) == 0){
                    input1letters.remove(currKey);
                    input2letters.remove(currKey);
                } else {
                    numDiff += Math.abs((val1-val2));
                }
            } else {
                numDiff += input1letters.get(currKey);
 
            }
        }

        if(numDiff == 0 && !input2letters.isEmpty()){
            return false;
        }

        //double checks if there are any letters that are considered for swap 
        for(Character currKey : input2letters.keySet()){
            numDiff -= input2letters.get(currKey);
        }

        if(Math.abs(numDiff) < k){
            return true ;
        }

        if(!input2letters.isEmpty() && !input1letters.isEmpty()){

            return false;
        }

        

        return true;
    }

    public static void main(String[] args){

        String test1a = "apple";
        String test1b = "peach";
        int k1 = 1;
        System.out.println("Test 1: " + findKAnagrams(test1a, test1b, k1));

        String test2a = "apple";
        String test2b = "peach";
        int k2 = 2;
        System.out.println("Test 2: " + findKAnagrams(test2a, test2b, k2));

        String test3a = "cat";
        String test3b = "dog";
        int k3 = 3;
        System.out.println("Test 3: " + findKAnagrams(test3a, test3b, k3));
        
        String test4a = "debit curd";
        String test4b = "bad credit";
        int k4 = 1;
        System.out.println("Test 4: " + findKAnagrams(test4a, test4b, k4));

        String test5a = "baseball";
        String test5b = "basketball";
        int k5 = 2;
        System.out.println("Test 5: " + findKAnagrams(test5a, test5b, k5));    

        String test6a = "hello";
        String test6b = "hello";
        int k6 = 1;
        System.out.println("Test 6: " + findKAnagrams(test6a, test6b, k6));   

        String test7a = "hello world";
        String test7b = "bye world";
        int k7 = 1;
        System.out.println("Test 6: " + findKAnagrams(test7a, test7b, k7));  
    }
}

//Completed this implementation in 33 minutes