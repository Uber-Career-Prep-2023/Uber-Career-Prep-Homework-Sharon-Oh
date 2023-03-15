/*  Technique: Variable-Size sliding window
 * This is because we look at the new growing substring at all times and compare 
 * with another pointer to see if it is equivalent.
 * 
 * Time and Space Complexity: O(n3) -> I believe because we have two for 
 * loops nested within each other but then we also have a do while that can look
 * at every element in the worst case, and is also nested. 
 */
public class ShortestSubstring {
    public static int findShortestSubstring(String input1, String input2){
        int shortestLength = Integer.MAX_VALUE;
        String currSubstring = "";
        if(input1.length() == 0 || input1 == null ||input2.length() == 0 || input2 == null){
            return -1;
        }

        for(int i = 0; i < input1.length(); i++){
            currSubstring = "";
            currSubstring += input1.charAt(i);
            for(int x = i+1; x < input1.length(); x++){
                currSubstring += input1.charAt(x);
                if(currSubstring.length() < input2.length()){
                    continue;
                } else{

                    boolean flag = true;
                    int index = 0;
                    String temp = currSubstring;
                    do{
                        char searchFor = input2.charAt(index);;
                        int searchIndex = temp.indexOf(searchFor);
                        if( searchIndex == -1){
                            flag = false;
                        } else if(searchIndex > -1){                        
                           temp = temp.substring(0, searchIndex);
                            temp += currSubstring.substring(searchIndex+1, currSubstring.length());
                        }
                        index = index +1;
                    } while(flag && index < input2.length());

                    if(flag ){
                        System.out.println("Current Substring: " + currSubstring + " Length: " + currSubstring.length());
                        shortestLength = currSubstring.length();
                    }
                }
            }
        }

        return shortestLength;
    }

    public static void main(String[] args){
        String test1a = "abracadabra";
        String test1b = "abc";
        System.out.println("Test 1: " + findShortestSubstring(test1a, test1b));

        String test2a = "zxycbaabcdwxyzzxwdcbxyzabccbazyx";
        String test2b = "zzyzx";
        System.out.println("Test 2: " + findShortestSubstring(test2a, test2b));

        String test3a = "dog";
        String test3b = "god";
        System.out.println("Test 3: " + findShortestSubstring(test3a, test3b));
        
        String test4a = "axyzxyzxyzxyz";
        String test4b = "xyz";
        System.out.println("Test 4: " + findShortestSubstring(test4a, test4b));

        String test5a = "def#s#d12##321d2#3#142#";
        String test5b = "###";
        System.out.println("Test 5: " + findShortestSubstring(test5a, test5b));
    }
}
