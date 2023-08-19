
/* This would need a dfs approach in that we need to go as far as we can with a starting
 * place. I didn't have enough time to implement that upon reflection, and maybe use a queue.
 * The way I approached this was go through each direction but it is 
 * not really practical with other words that can be in a V formation. 
 * This implementation would be almost O(n^3) because I have basically three inner loops
 * and a space of O(n^2) due to the number of ArrayLists that exist and then are deleted.  
 */
import java.util.*;

class Boggle {
    public static ArrayList<String> getBoggleWords(ArrayList<String> dictionary, char[][] board) {
        ArrayList<String> toReturn = new ArrayList<String>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                ArrayList<String> horizontal = searchHorizontal(dictionary, board, col, row);
                ArrayList<String> vertical = searchVertical(dictionary, board, col, row);

                toReturn.addAll(horizontal);
                toReturn.addAll(vertical);
            }
        }
        return toReturn;
    }

    private static ArrayList<String> searchHorizontal(ArrayList<String> dictionary, char[][] board, int currCol,
            int currRow) {
        ArrayList<String> words = new ArrayList<String>();
        String curr = "";
        for (int i = currCol; i < board[currRow].length; i++) {
            curr += board[currRow][currCol];
            if (dictionary.contains(curr)) {
                words.add(curr);
            }
        }
        return words;
    }

    private static ArrayList<String> searchVertical(ArrayList<String> dictionary, char[][] board, int currCol,
            int currRow) {
        ArrayList<String> words = new ArrayList<String>();
        String curr = "";
        for (int i = currRow; i < board.length; i++) {
            curr += board[i][currCol];
            if (dictionary.contains(curr)) {
                words.add(curr);
            }
        }
        return words;
    }

    public static void main(String[] args) {
        ArrayList<String> dictionary = new ArrayList<String>();
        dictionary.add("ace");
        dictionary.add("ape");
        dictionary.add("cape");
        dictionary.add("clap");
        dictionary.add("clay");
        dictionary.add("gape");
        dictionary.add("grape");
        dictionary.add("lace");
        dictionary.add("lap");
        dictionary.add("lay");
        dictionary.add("mace");
        dictionary.add("map");
        dictionary.add("may");
        dictionary.add("pace");
        dictionary.add("pay");
        dictionary.add("rap");
        dictionary.add("ray");
        dictionary.add("tap");
        dictionary.add("tape");
        dictionary.add("trap");
        dictionary.add("tray");
        dictionary.add("yap");

        char[][] board = {
                { 'a', 'd', 'e' },
                { 'r', 'c', 'p' },
                { 'l', 'a', 'y' },
        };

        ArrayList<String> results = getBoggleWords(dictionary, board);
        results.toString();

    }
}