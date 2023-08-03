/* Ultimately did not finish because of the properties of Java that made it hard to be able to 
 * use a data structure to handle all the different data types (String & Double)
 */
import java.util.*;

public class VacationDestinations{
    public int getVacationDestinations(ArrayList<Object[]> allDestinations, String origin, Double k){
        if(allDestinations == null || allDestinations.size() == 0 || origin == null || k < -1){
            return 0;
        }
        int numTrips = 0;

        for(Object[] currTrip: allDestinations){
            System.out.print(currTrip[0].equals(origin) + "\t");
            System.out.print(currTrip[1].equals(origin) + "\t");

            //also this idea is a lot harder because we have to be able to change based on the compiled order if we do from 
            // nyc ->boston -> newport would be 4+1.5 -> 5.5 
            if((currTrip[0].equals(origin) || currTrip[1].equals(origin)) && (currTrip[2].compareTo(k) <= 0)){
                numTrips++;
            } 
        }

        return numTrips;
    }

    public static void main(String[] args){
        VacationDestinations v = new VacationDestinations();
        ArrayList<Object[]> exampleDestinations = new ArrayList<Object[]>();
        Object[] ex1 = {"Boston", "New York", 4};
        exampleDestinations.add(ex1);
        Object[] ex2 = {"New York", "Philadelphia.", 2};
        exampleDestinations.add(ex2);
        Object[] ex3 = {"Boston", "Newport", 1.5};
        exampleDestinations.add(ex3);
        Object[] ex4 = {"Washington, D.C.", "Harper's Ferry", 1};
        exampleDestinations.add(ex4);
        Object[] ex5 ={"Boston", "Portland", 2.5};
        exampleDestinations.add(ex5);
        Object[] ex6 = {"Philadelphia", "Washington, D.C.", 2.5};
        exampleDestinations.add(ex6);

        System.out.println(v.getVacationDestinations(exampleDestinations, "New York", 5.0));
        System.out.println(v.getVacationDestinations(exampleDestinations, "New York", 7.0));
        System.out.println(v.getVacationDestinations(exampleDestinations, "New York", 8.0));

    }

}