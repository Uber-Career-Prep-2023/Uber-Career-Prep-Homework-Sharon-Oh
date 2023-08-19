/* Tries are a little more confusing than I would have thought. 
 * I was working on the tries through the website and then I work.
 */
import java.util.*;

class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // O(n^2) because it is traversing through the word and looking at each element
  // but doing operations on each character
  public void insert(String word) {
    TrieNode currNode = root;

    for (int i = 0; i < word.length(); i++) {
      char currChar = word.charAt(i);
      int index = currChar - 'a';

      if (currNode.children.size() == 0 || currNode.children.get(index) == null) {
        currNode.children.add(index, new TrieNode());
      }

      currNode = currNode.children.get(index);
    }
    currNode.validWord = true;
  }

  // O(n) because it is traversing through the word and looking at each element
  public boolean isValidWord(String word) {
    TrieNode currNode = root;

    for (int i = 0; i < word.length(); i++) {
      char currChar = word.charAt(i);
      int index = currChar - 'a';

      if (currNode.children.get(index) == null) {
        return false;
      }
      currNode = currNode.children.get(index);
    }
    return currNode.validWord;
  }

  // I did not have enough time to figure out how the rest of this works 
  public void remove(String word) {

  }

  class TrieNode {
    ArrayList<TrieNode> children;
    boolean validWord;

    public TrieNode() {
      children = new ArrayList<TrieNode>();
      validWord = false;
    }
  }
  public static void main(String[] args) {
    Trie test = new Trie();
    test.insert("and");
    test.insert("ant");
    test.insert("dad");
    test.insert("do");

    System.out.println(test.isValidWord("and"));
    System.out.println(test.isValidWord("any"));

  }
}
