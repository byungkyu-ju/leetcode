class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { // 시작지점
                    return dfs(grid,i,j);
                }
            }
        }
        return 0;
    }
    
    private int dfs(int[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1; //이동이 불가능한 땅에서 stop => 1
        }
        
        if (grid[i][j] == -1) {
            return 0; // visited
        }
        
        if (grid[i][j] == 0) {
            return 1; // 마지막 물
        }
        
        grid[i][j] = -1; //visited
        
        int lineCount = 0;
        
        // 오른쪽
        lineCount += dfs(grid,i,j+1);    
        // 왼쪽
        lineCount += dfs(grid,i,j-1);    
        // 아래
        lineCount += dfs(grid,i+1,j);    
        // 위
        lineCount += dfs(grid,i-1,j);
        
        return lineCount;
    }
}
