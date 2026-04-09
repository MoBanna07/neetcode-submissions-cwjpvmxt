class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> cells = new LinkedList<int[]>();

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0)
                    cells.add(new int[]{r,c});
            }
        }

        if(cells.size() == 0)
            return;

        int[][] dirs = new int[][]{{-1,0}, {1,0},{0,-1},{0,1}};

        int dis = 0;
        while(!cells.isEmpty()){
            int[] curr = cells.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : dirs){
                int rAdj = r + dir[0];
                int cAdj = c + dir[1];
                if(rAdj < 0 || cAdj < 0 || rAdj >= grid.length || cAdj >= grid[0].length || grid[rAdj][cAdj] != Integer.MAX_VALUE)
                    continue;

                cells.add(new int[]{rAdj,cAdj});
                grid[rAdj][cAdj] = Integer.min(grid[rAdj][cAdj], grid[r][c] + 1);
            }
        }
    }
}
