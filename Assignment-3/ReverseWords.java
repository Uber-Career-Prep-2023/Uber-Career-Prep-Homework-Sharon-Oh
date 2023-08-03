/* I'm not sure how long this took, but it seems to be less than 40 minutes.
 * This one is probably O^(n) because it only uses one loop and possibly one more variable than necessary.s
 */
public class ReverseWords {
    public String getReverseWords(String phrase){
        if (phrase == null || phrase.isEmpty()){
            return null;
        }
        String[] allWords = phrase.split(" ");
        String toReturn = "";

        for(int i = allWords.length-1; i >= 0; i --){
            toReturn += allWords[i] + " ";
        }

        return toReturn;
    }
    public static void main(String[] args){
        ReverseWords test = new ReverseWords();

        System.out.println(test.getReverseWords(""));
        System.out.println(test.getReverseWords(null));
        System.out.println(test.getReverseWords("Uber Career Prep"));
        System.out.println(test.getReverseWords("Emma lives in Brooklyn, New York."));
        System.out.println(test.getReverseWords("I am writing more tests for this program."));
    }
}

