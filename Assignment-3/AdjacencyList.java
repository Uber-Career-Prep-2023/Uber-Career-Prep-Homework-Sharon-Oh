/* Adjacency List/ Representation of a Graph 
 * This is only O(n) implementation because we used one loop to go through the input
 * In total this problem probably took me around 40 minutes. 
 */
import java.util.*;

public class AdjacencyList {
    public Map<Integer, Set<Integer>> getAdjacencyList(ArrayList<Integer[]>list){
        if(list.size() == 0 || list == null || list.isEmpty()){
            return null;
        }

        Map<Integer, Set<Integer>> adjList = new HashMap<Integer, Set<Integer>>(); 
        for(int i = 0; i < list.size(); i++){
            Integer first = list.get(i)[0];
            Integer second = list.get(i)[1];

            if(!adjList.containsKey(first)){
                Set<Integer> neighbors = new HashSet<Integer>();
                neighbors.add(second);
                adjList.put(first, neighbors);
            } else {
                Set<Integer> neighbors = adjList.get(first);
                neighbors.add(second);
                adjList.put(first, neighbors);
            }

            if(!adjList.containsKey(second)){
                Set<Integer> neighbors = new HashSet<Integer>();
                adjList.put(second, neighbors);
            }
        }
        return adjList;
    }

    public static void main(String[] args){
        AdjacencyList test = new AdjacencyList();

        ArrayList<Integer[]> example1 = new ArrayList<Integer[]>();
        Integer[] ex1pair1 = {1,2};
        Integer[] ex1pair2 = {2,3};
        Integer[] ex1pair3 = {1,3};
        Integer[] ex1pair4 = {3,2};
        Integer[] ex1pair5 = {2,0};

        example1.add(ex1pair1);
        example1.add(ex1pair2);
        example1.add(ex1pair3);
        example1.add(ex1pair4);
        example1.add(ex1pair5);

        Map<Integer, Set<Integer>> answer1 = test.getAdjacencyList(example1);

        for (Integer currKey : answer1.keySet()){

            Set<Integer> currSet = answer1.get(currKey);
            System.out.print(currKey +": ");
            for(Integer curr: currSet){
                System.out.print(curr + "\t");
            }
            System.out.println();
        }
    }
}
