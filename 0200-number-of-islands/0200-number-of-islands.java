class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') { // land
                    result++;
                    dfs(grid, i, j); // 이어진 land가 끝날때까지 dfs 탐색
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = 'x'; // 방문
        
        //오른쪽
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
            dfs(grid,i,j+1);
        }

        //왼쪽
        if (j -1 >= 0 && grid[i][j-1] == '1') {
            dfs(grid,i,j-1);
        }

        // 아래
        if (i +1 < grid.length && grid[i+1][j] == '1') {
            dfs(grid,i+1,j);
        }

        // 위
        if (i - 1 >= 0 && grid[i-1][j] == '1') {
            dfs(grid,i-1,j);
        }
    }
}