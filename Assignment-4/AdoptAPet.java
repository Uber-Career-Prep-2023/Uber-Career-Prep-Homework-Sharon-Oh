/* I was working with multiple classes and realized I should have looked into it 
 * more before I decided to use it. I couldn't figure out in time how to 
 * use it wihtin  the class. The getAPet method is only O(n) and the whole 
 * problem is O(n) in terms of space.
 */
import java.util.*;

public class AdoptAPet {

    private static ArrayList<Pet> pets;
    private Pet getAPet;

    public AdoptAPet() {
        pets = new ArrayList<Pet>();
    }

    public void addAnimal(Pet toAdd) {
        pets.add(toAdd);
    }

    public Pet getAPet(Customer c) {
        if (c.searchingFor == null || !c.type.equals("person")) {
            return null;
        }

        int longestDay = 0;
        Pet toReturn = null;
        for (Pet curr : pets) {
            if (curr.type.equals(c.searchingFor)) {
                if (curr.days > longestDay) {
                    longestDay = curr.days;
                    toReturn = curr;
                }
            }
        }

        pets.remove(toReturn);

        return toReturn;
    }


    public static void printPet(Pet curr) {
        System.out.println(curr.name + ", " + curr.type);
    }
    public static void main(String[] arg) {
        AdoptAPet test = new AdoptAPet();
        test.addAnimal(new Pet("Sadie", "dog", 4));
        test.addAnimal(new Pet("Woof", "cat", 7));
        test.addAnimal(new Pet("Chirpy", "dog", 2));
        test.addAnimal(new Pet("Lola", "dog", 1));

        printPet(test.getAPet(new Customer("Bob", "person", "dog"));)
    }
}
