/*  This is the closest to the two arrays pointer. I would not say it is 
 * necessarily the same thing. But because I used the indexOf method. 
 * 
 * Time and Space - O(2n) this is because in the worst case, we would be 
 * looking at every single element in the loop. 
 */
public class BackspaceStringCompare {
    public static boolean compareBackspaceString(String input1, String input2){

        //if the # is not found 
        if(input1.indexOf("#") == -1 && input2.indexOf("#") == -1){
            return input1.equals(input2);
        }
        
        while(input1.indexOf("#") > -1){
            int index = input1.indexOf("#");
            if(index == 1){
                input1 = input1.substring(2);
            } else {
                String temp = input1.substring(0, index-1);
                temp += input1.substring(index+1);
                input1 = temp;
            }
           
        }

        while(input2.indexOf("#") > -1){
            int index = input2.indexOf("#");
            
            if(index == 1){
                input2 = input2.substring(2);
            } else {
                String temp = input2.substring(0, index-1);
                temp += input2.substring(index+1);
                input2 = temp;
            }
           
        }

        return input1.equals(input2);
    }

    public static void main(String[] args){
        
        String test1a = "abcde";
        String test1b = "abcde";
        System.out.println("Test 1: " + compareBackspaceString(test1a, test1b));

        String test2a = "Uber Career Prep";
        String test2b = "u#Uber Careee#r Prep";
        System.out.println("Test 2: " + compareBackspaceString(test2a, test2b));

        String test3a = "abcdef###xyz";
        String test3b = "abcw#xyz";
        System.out.println("Test 3: " + compareBackspaceString(test3a, test3b));
        
        String test4a = "abcdef###xyz";
        String test4b = "abcdefxyz###";
        System.out.println("Test 4: " + compareBackspaceString(test4a, test4b));

        String test5a = "def###";
        String test5b = "abc###";
        System.out.println("Test 5: " + compareBackspaceString(test5a, test5b));
        
    }
}
//this implementation took me around 15 minutes 