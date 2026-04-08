class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(grid, visited, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return;

        if (grid[r][c] == '0' || visited[r][c])
            return;

        visited[r][c] = true;

        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r, c - 1);
        dfs(grid, visited, r, c + 1);
    }
}