class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean [][] checked;
        if(grid.length > 0){
            checked = new boolean[grid.length] [grid[0].length];
            for(int r = 0; r < grid.length; r++){
                for(int c = 0; c < grid[r].length; c++){
                    if(!checked[r][c] && grid[r][c] == '1'){
                        checked[r][c] = true;
                        islands += numIslandsHelper(checked, r,c,grid);
                    }
                }
            }
        }
        return islands;
    }

    public int numIslandsHelper(boolean [][] checked, int r, int c, char[][] grid){
        if(r-1 >= 0 && !checked[r-1][c]){
            checked[r-1][c] = true;
            if(grid[r-1][c] == '1'){
                numIslandsHelper(checked, r-1,c,grid);
            }
        }
        if(r+1 < grid.length && !checked[r+1][c]){
            checked[r+1][c] = true;
            if(grid[r+1][c] == '1'){
                numIslandsHelper(checked, r+1,c,grid);
            }
        }
        if(c-1 >= 0 && !checked[r][c-1]){
            checked[r][c-1] = true;
            if(grid[r][c-1] == '1'){
                numIslandsHelper(checked, r,c-1,grid);
            }
        }
        if(c+1 < grid[r].length && !checked[r][c+1]){
            checked[r][c+1] = true;
            if(grid[r][c+1] == '1'){
                numIslandsHelper(checked, r,c+1,grid);
            }
        }
        return 1;
    }
}
