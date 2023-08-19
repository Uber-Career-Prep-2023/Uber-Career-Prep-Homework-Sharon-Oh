/* I ran out of time because my I kept redoing my idea, 
* but if I were to correctly implement this: it would be a graph problem with 
* a hash map that would have an adjacency list and then we would look through the 
 * adjacency list. I remembered that idea in the last second and didn't have enough
 * time to implement it again. It would be around O(n) because we would have several loops. 
 */
import java.util.*;

public class PrerequisiteCourses {
    public ArrayList<String> getPrerequisiteCourses(ArrayList<String> allCourses, HashMap<String, String> prereqCourses){
        //if the arrays are empty
        if(allCourses == null || prereqCourses == null || allCourses.size() == 0 || prereqCourses.size == 0){
            return null;
        }
        
        //create a new list
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();
        for(String currCourse: allCourses){
            adjList.put(currCourse, new ArrayList<String>());
        }

        // ArrayList<String> courseList = new ArrayList<String>();
        // String currCourse = allCourses[0];

        // while(courseList.size < allCourses.size){
        //     if(!prereqCourses.containsKey(currCourse) && prereqCourses.containsValue(currCourse)){
        //         courseList.push(0);
                
        //     } 

        //     if(!prereqCourses.containsKey(currCourses)){
        //         String val = prereqCourses.get(currCourses);
                
        //     }
        // }

    }

    public static void main(String[] args) {
    
    }
}

