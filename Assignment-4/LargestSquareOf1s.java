/* For this problem, I know we need to look thorugh all the neighbors in order to figure out the width
 * but I wasn't exactly sure how to implement that I'm not exactly sure how to approach this problem
 * so I will search it up later. yeah, i'm not too sure how to approach it and 
 * i felt like i couldnt get to an answer without hints. 
 */
import java.util.*;

public class LargestSquareOf1s {
    public static int getLargestSquareOf1s(int[][] board){
        if(board.length == 0){
            return -1;
        }

        int numWidth = 0;
        
        // to iterate through the board
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){  
                
                //if its the top left of the board
                if(row == 0 && col == 0){
                    if(board[row][col]== 1 && board[row+1][col] == 1 && board[row][col+1] == 1 && board[row+1][col+1] == 1){
                        numWidth++;
                    }
                }
                // if its the bottom right of the board
                else if(row+1 == board.length && col+1 == board[row].length){
                    if(board[row][col] == 1){
                        numWidth++;
                    }
                } 
                else {
                    if(board[row][col]== 1 && board[row+1][col] == 1 && board[row][col+1] == 1 && board[row+1][col+1] == 1){
                        numWidth++;
                    }
                }
            }
        }

        return numWidth;
    }

    public static void main(String[] args){
         int[][] matrix = {
            {0, 1, 0, 1, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 0, 0}
        };

        System.out.println(getLargestSquareOf1s(matrix));
    }
}
