class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottingFruits = new ArrayDeque<>();
        List<String> freshFruits = new ArrayList<>();
        int minutes = -1;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++){
                if(grid[r][c] == 2){
                    grid[r][c] = 0;
                    rottingFruits.add(new int[]{r,c});
                }
                else if(grid[r][c] == 1){
                        String pos = "" + r + c;
                        freshFruits.add(pos);
                        grid[r][c] = Integer.MAX_VALUE;
                }
                else {
                    grid[r][c] = -1;
                }

            }
        }
        
        if(freshFruits.isEmpty())
            return 0;

        if(rottingFruits.isEmpty())
            return minutes;

        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        while(!rottingFruits.isEmpty()){
            int[] curr = rottingFruits.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : dirs){
                int rAdj = r + dir[0];
                int cAdj = c + dir[1];

                if(rAdj < 0 || cAdj < 0 || rAdj >= grid.length || cAdj >= grid[0].length || grid[rAdj][cAdj] != Integer.MAX_VALUE)
                    continue;
                
                rottingFruits.add(new int[]{rAdj,cAdj});
                grid[rAdj][cAdj] = Integer.min(grid[rAdj][cAdj], grid[r][c] + 1);
                String pos = "" + rAdj + cAdj; 
                freshFruits.remove(pos);
                minutes = Integer.max(minutes, grid[rAdj][cAdj]);
            }
        }

        if(!freshFruits.isEmpty()){
                return -1;
        }

        return minutes;        
    }
}
