class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int[] count = new int[1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count[0] = 0; // 초기화 후 새 섬 check
                    dfs(grid,i,j,m,n, count);
                    result = Math.max(count[0], result);
                }
                
            }
        }
        return result;
    }
    
    private void dfs(int[][] grid, int i, int j, int m, int n, int[] count) {
        if(i < 0 || j < 0 || i >=m || j >= n ||i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        
        grid[i][j] = -1;
        count[0]++;
        
        // 오른쪽
        dfs(grid,i,j+1,m,n,count);    
        // 왼쪽
        dfs(grid,i, j-1,m,n,count);
        // 아래
        dfs(grid,i+1,j,m,n,count);
        // 위
        dfs(grid,i-1,j,m,n,count);
    }
}