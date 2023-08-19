/* I'm not sure what technique this is technically. 
 * The run time is O(n^2) and the space is O(n) 
 * run time reasoning is because it is two loops within each other and in worst case
 * it will run a long time, and then the space is due to the ArrayList
 */
import java.util.*;

public class CatalanNumbers {
    public ArrayList<Integer> getCatalanNumbers(int n){
        if(n < 0){
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        for(int i = 1; i <= n; i ++){
            int curr = 0;
            for (int x = 0; x < i; x++) {
                curr += numbers.get(x) * numbers.get(i - x - 1);
            }
            numbers.add(curr);
        }

        return numbers;
        
        
    }

    public static void main (String[] args){
        CatalanNumbers test = new CatalanNumbers();
        System.out.println(test.getCatalanNumbers(5).toString());
        System.out.println(test.getCatalanNumbers(1).toString());
        System.out.println(test.getCatalanNumbers(-12).toString());
        System.out.println(test.getCatalanNumbers(3).toString());


    }
}

