/* Forward and Backwards Two-Pointer in that the forward pointer was traversing 
 * through the line itself, and the backwards pointer was traversing through the 
 * list of vowels backwards. 
 * I also utilize the Linear Search to search for vowels in the original traversal. 
 * 
 * This program has O(2n) because it traverses the list twice in two separate loops. 
 */

import java.util.*;
public class ReverseVowels {
    
    public String reverseVowel(String line){
        String toReturn = "";
        ArrayList<String> vowels = new ArrayList<String>();

        //traverses forwards to search for vowels 
        for (int i = 0; i < line.length(); i++){
            char letter = line.charAt(i);
            //changes back to string, to change into lowercase
            String currLetter = Character.toString(letter);
            if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
                letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U'){
                   
                vowels.add(currLetter);
                
            }
        }

        //edge case which breaks the program if there were no vowels
        if (vowels.size() == 0){
            return line;
        }


        //this will keep track of which vowel we are looking to add, but backwards
        int counter = vowels.size()-1 ;

        //traverses forwards to look at each string
        for (int x = 0; x < line.length(); x++){
            char letter = line.charAt(x);

            if((letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
                letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U')){
                toReturn += vowels.get(counter);
                counter --;
            } else {
                toReturn += letter;
            }   
            
        }
        return toReturn;
    }

    public static void main(String[] args){
        ReverseVowels test = new ReverseVowels();

        String input1 = "Uber Career Prep";
        System.out.println(test.reverseVowel(input1));

        String input2 = "xyz";
        System.out.println(test.reverseVowel(input2));

        String input3 = "flamingo";
        System.out.println(test.reverseVowel(input3));

        String input4 = " ";
        System.out.println(test.reverseVowel(input4));

        String input5 = "wqiNojiasP";
        System.out.println(test.reverseVowel(input5));
    }
}

// This code took around 37 minutes to complete. 