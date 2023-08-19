/* this is probably a graph problem
 * i wasnt able to finish, because it was difficult writing the test and then debugging afterwards in the alloted time
 *  i think it is around O(3n) because we have three loops 
 * and then the storage is around O(2n) because we have a hashMap and a set that is created
 */
import java.util.*;

public class RoadNetworks {
    public int getRoadNetworks(ArrayList<String> towns, ArrayList<ArrayList<String>> roads) {
        Map<String, String> parent = new HashMap<>();
        
        // Initialize each town as its own parent
        for (String currTown : towns) {
            parent.put(currTown, currTown);
        }
        
        // connect the towns that are connected by roads
        for (ArrayList<String> road : roads) {
            String town1 = road.get(0);
            String town2 = road.get(1);
            
            String parent1 = findTown(parent, town1);
            String parent2 = findTown(parent, town2);

            if(!parent1.equals(parent2)){
                parent.put(parent1, parent2);
            }
        }
        

        //use a set to get only the unique towns
        Set<String> uniqueParents = new HashSet<>();
        for (String town : towns) {
            System.out.println("Town: " + town + " " + findTown(parent,town));
            uniqueParents.add(findTown(parent, town));
        }
        
        return uniqueParents.size();
    }
    
    private String findTown(Map<String, String> parents, String currTown){
        //if there isn't a path, then continue searching
        if(!parents.get(currTown).equals(currTown)){
            parents.put(currTown, findTown(parents, parents.get(currTown)));
        }

        return parents.get(currTown);
    }
    
    public static void main(String[] args) {
        RoadNetworks test = new RoadNetworks();

        ArrayList<String> towns1 = new ArrayList<String>();
        towns1.add("Skagway");
        towns1.add("Juneau");
        towns1.add("Gustavus");
        towns1.add("Homer");
        towns1.add("Port Alsworth");
        towns1.add("Glacier Bay");
        towns1.add("Fairbanks");
        towns1.add("McCarthy");
        towns1.add("Copper Center");
        towns1.add("Healy");
         
        ArrayList<String> pair1 = new ArrayList<String>();
        pair1.add("Anchorage");
        pair1.add("Homer");

        ArrayList<String> pair2 = new ArrayList<String>();
        pair2.add("Glacier Bay");
        pair2.add("Gustavus");

        ArrayList<String> pair3 = new ArrayList<String>();
        pair3.add("Anchorage");
        pair3.add("Homer");

        ArrayList<String> pair4 = new ArrayList<String>();
        pair4.add("Glacier Bay");
        pair4.add("Gustavus");

        ArrayList<String> pair5 = new ArrayList<String>();
        pair5.add("Copper Center");
        pair5.add("McCarthy");

        ArrayList<String> pair6 = new ArrayList<String>();
        pair6.add("Anchorage");
        pair6.add("Copper Center");

        ArrayList<String> pair7 = new ArrayList<String>();
        pair7.add("Copper Center");
        pair7.add("Fairbanks");

        ArrayList<String> pair8 = new ArrayList<String>();
        pair8.add("Healy");
        pair8.add("Fairbanks");

        ArrayList<String> pair9 = new ArrayList<String>();
        pair9.add("Healy");
        pair9.add("Anchorage");
        
        ArrayList<ArrayList<String>> roads1 = new ArrayList<ArrayList<String>>();
        int networkCount1 = test.getRoadNetworks(towns1, roads1);
        System.out.println("Number of road networks: " + networkCount1);
        
    }
}
