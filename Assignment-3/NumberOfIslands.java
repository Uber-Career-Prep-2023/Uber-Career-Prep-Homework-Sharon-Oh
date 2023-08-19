/* this one implements DFS. Technically there are two loops but those are needed 
* to implement this code, so I would assume that the runtime would be around O(n)
 *  or O(n^2) because we also have a recursive implementation that would require 
 * a good amount of time. 
 * However in terms of storage, I believe that this would be O(n) because we are 
 * only using the grid given to us and no data structure that is large. 
 */
public class NumberOfIslands {
    public int findIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;
        
        //iterate over the whole grid
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    numIslands++;
                    search(grid, i, j);
                }
            }
        }
        
        return numIslands;
    }
    

    private void search(int[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        if (row < 0 || col < 0 || row >= numRows || col >= numCols || grid[row][col] != 1) {
            return;
        }
        
        // since we have visited this cell.
        grid[row][col] = -1;
        
        // look at all neighboring cells
        search(grid, row - 1, col); // Up
        search(grid, row + 1, col); // Down
        search(grid, row, col - 1); // Left
        search(grid, row, col + 1); // Right
    }
    
    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        int[][] grid1 = {
            {1, 0, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };

        System.out.println(test.findIslands(grid1)); 
        
        int[][] grid2 = {
            {1, 0, 0},
            {0, 0, 0}
        };
        
        System.out.println(test.findIslands(grid2)); 
    }
}
