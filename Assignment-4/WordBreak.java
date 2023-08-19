
/*  I'm not sure if this is only a Java issue, but the case of the words mattered
 * and I'm not sure how to fix it exactly. This was a sliding window kind of problem
 * where I had a pointer that was ahead trying to find the first occurrence of a correct word
 * The runtime is O(n) and the space is O(n).
 */
import java.util.*;

public class WordBreak {
    public static boolean isWordBreak(ArrayList<String> dictionary, String word) {
        if (dictionary == null || word == null || dictionary.size() == 0 || word.isBlank()) {
            return false;
        }

        if (dictionary.contains(word)) {
            return true;
        }

        int start = 0;
        boolean flag = false;
        for (int i = 1; i < word.length(); i++) {
            String curr = word.substring(start, i + 1);

            if (dictionary.contains(curr)) {
                start = i + 1;
                // so if the rest of the chunk is a word that exists
                if (dictionary.contains(word.substring(start))) {
                    flag = true;
                    break;
                }
                // if it is the last leter
                if (i + 1 == word.length()) {
                    flag = true;
                }
            }

            if (i + 1 == word.length()) {
                flag = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        ArrayList<String> dictionary = new ArrayList<String>();
        dictionary.add("Elf");
        dictionary.add("Go");
        dictionary.add("Golf");
        dictionary.add("Man");
        dictionary.add("Manatee");
        dictionary.add("Not");
        dictionary.add("Note");
        dictionary.add("Pig");
        dictionary.add("Quip");
        dictionary.add("Tee");
        dictionary.add("Teen");

        System.out.println(isWordBreak(dictionary, "ManGolf"));
        System.out.println(isWordBreak(dictionary, "GoMan"));
        System.out.println(isWordBreak(dictionary, "PigTeen"));
        System.out.println(isWordBreak(dictionary, "PiGTeEn"));
        System.out.println(isWordBreak(dictionary, "GoMan"));
        System.out.println(isWordBreak(dictionary, "GoMpoop"));

    }
}
