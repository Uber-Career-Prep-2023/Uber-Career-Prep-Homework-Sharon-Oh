
/* I ran out of time for this, I know that this is a graph problem and then since it 
 * is a shortest path problem, so we would use a queue to keep track and another 
 * thing to keep track of the visited cities/states.@interface
 * I believe this is O(n^2) because we have the loop inside of the loop. 
 * The storage/space is going to be like O(n) because we have different data structures 
 * but I don't think they take up a lot of memory. 
 */
import java.util.*;

public class AlternatingPath {
    public int shortestAlternatingPath(List<Triplet> edges, String origin, String destination) {
        Map<String, Map<String, Set<String>>> graph = new HashMap<>();

        // create a graph using adjacency list
        for (Triplet edge : edges) {
            if (graph.get(edge.source) == null) {
                graph.put(edge.source, new HashMap<>());
            }

            if (graph.get(edge.source).get(edge.destination) == null) {
                graph.get(edge.source).put(edge.destination, new HashSet<>());
            }

            graph.get(edge.source).get(edge.destination).add(edge.color);
        }

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(origin, "none", 0));

        // use the queue to find the shortest path
        while (!queue.isEmpty()) {
            State currState = queue.poll();
            String currCity = currState.city;
            int currSteps = currState.steps;

            // once we hit the final destination
            if (currCity.equals(destination)) {
                return currSteps;
            }

            // checks neighbors to find if the path continues with other neighbors
            if (graph.containsKey(currCity)) {
                for (Map.Entry<String, Set<String>> neighborEntry : graph.get(currCity).entrySet()) {
                    String neighborCity = neighborEntry.getKey();
                    Set<String> neighborColors = neighborEntry.getValue();
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}

// creating classes to make it easier to adjust to Java standards
class Triplet {
    String source;
    String destination;
    String color;

    public Triplet(String source, String destination, String color) {
        this.source = source;
        this.destination = destination;
        this.color = color;
    }
}

class State {
    String city;
    String color;
    int steps;

    public State(String city, String color, int steps) {
        this.city = city;
        this.color = color;
        this.steps = steps;
    }
}
