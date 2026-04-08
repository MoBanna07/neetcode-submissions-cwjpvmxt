class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c] == 1){
                    maxArea = Integer.max(maxArea, maxAreaOfIsland(r,c,grid));
                }
            }
        }
        return maxArea;
    }

    public int maxAreaOfIsland(int r, int c, int[][]grid){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return 0;
        
        if(grid[r][c] == 0)
            return 0;

        int area = 1;
        grid[r][c] = 0;
        area += maxAreaOfIsland(r-1,c,grid);
        area += maxAreaOfIsland(r+1,c,grid);
        area += maxAreaOfIsland(r,c-1,grid);
        area += maxAreaOfIsland(r,c+1,grid);

        return area;
    }
}
