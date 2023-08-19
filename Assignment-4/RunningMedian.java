/* Since this is running median I wasn't sure when it would stop 
 * This runtime is O(n + nlgn) times with n being the number of inputs 
 * and nlgn is the sort that we do
 * the space is O(n) because we only need the arraylist. 
 * We have the sort than binary search approach where we sort the list and then 
 * handle what we want to do with it afterwards. 
 */
import java.util.*;

public class RunningMedian {
    public void getRunningMedian() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        //continues running until the console is closed 
        do {
            System.out.print("Input: " + list.toString());
            int input = scanner.nextInt();

            list.add(input);

            sortMedian(list);
        } while (true);
    }

    //this is what calculates the median
    private void sortMedian(ArrayList<Integer> list){
        Collections.sort(list);
        int midIndex = list.size()/2;

        //if list is even 
        if(list.size()%2 == 0){
            System.out.println("Output: " + ((double)(list.get(midIndex) + list.get(midIndex-1))/2));
        }

        System.out.println("Output: " + list.get(midIndex));
    }

    public static void main(String[] args){
        RunningMedian rm = new RunningMedian();
        rm.getRunningMedian();
    }
}
