/* I ran out of time, but I realized that we needed to be able to figure out 
 * how to keep track of the running minCost and also look at other numbers because
 * the logic doesn't work properly with the second given case. 
 * This implementation would need two different pointers and a running pointer
 * ahead where it has a running window. 
 * this implementation is O(n) and the space is O(n).
 */
public class MinCostStairClimbing {
    public static int getMinCostStairClimbing(int[] stairs){
        if(stairs == null || stairs.length == 0){
            return -1;
        }

        int minCost = 0;
        int counter = 0;

        while(counter <= stairs.length-1){

            // if(counter == stairs.length || counter > stairs.length){
            //     minCost += stairs[stairs.length-1];
            //     break;
            // }

            // if(stairs[counter] < stairs[counter+1]){
            //     minCost += stairs[counter];
            //     counter++;
            // } else if(stairs[counter+1] < stairs[counter]){
            //     minCost += stairs[counter+1];
            //     counter +=2;
            // }

            // if(counter+1 == stairs.length){
            //     break;
            // }

            if(counter == stairs.length-1){
                System.out.println("Option 3: "+stairs[counter]);
                minCost += stairs[counter];
                break;
            }

            int oneStep = minCost + stairs[counter];
            int twoSteps = minCost + stairs[counter+1];

            if(oneStep < twoSteps){
                System.out.println("Option 1: " + stairs[counter]);
                minCost += stairs[counter];
                counter++;
            } else if(twoSteps < oneStep){
                System.out.println("Option 2: " + stairs[counter+1]);
                minCost += stairs[counter+1];
                counter+=2;
            } 

            if(counter+1 == stairs.length){
                break;
            }
        }

        return minCost;
    }

    public static void main(String[] args){
        int[] example1 = {4,1,6,3,5,8};
        System.out.println(getMinCostStairClimbing(example1));
        int[] example2 = {11,8,3,4,9,13,10};
        System.out.println(getMinCostStairClimbing(example2));
        int[] example3 = {1,2,3,4};
        System.out.println(getMinCostStairClimbing(example3));

    }
}
