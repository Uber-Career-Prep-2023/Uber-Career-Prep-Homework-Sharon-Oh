/* Tabulation or Bottom Up
 * this is O(n^2) due to the two loops.
 * I would assume space to be O(n)
 */
import java.util.*;

public class CoinChange {
    public static int getCoinCombo(int[] coins, int target) {
        int[] arr = new int[target + 1];
        arr[0] = 1; //base value 

        //bottom up method
        for (int coin : coins) {
            for (int amount = coin; amount <= target; amount++) {
                arr[amount] += arr[amount - coin];
            }
        }
        
        return arr[target];
    }
     public static void main(String[] args) {
        int[] coins = {2, 5, 10};
        int sum1 = 20;
        int sum2 = 15;

        System.out.println(getCoinCombo(coins, sum1)); 
        System.out.println(getCoinCombo(coins, sum2)); 

        int[] coins2 = {1,2};
        int sum3 = 5;

        System.out.println(getCoinCombo(coins2, sum3)); // 1,1,1,1,1 & 2,2,1 & 1,2,2
    }
}
