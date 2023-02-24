class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // O이면서, 마지막 bottom이 아닐 때 It is on the border that should not be flipped.
                if (board[i][j] == 'O' && ( i == 0 || j == 0 || i == board.length -1 || j == board[0].length -1)) {
                    dfs(board, i, j);
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' ) {
                    board[i][j] = 'X';
                }else if (board[i][j] == 'V') { // 방문했던 V 는 X 로
                    board[i][j] = 'O';
                }
                
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') { //방문할 필요가 없으면 패스
            return;
        }
    
        board[i][j] = 'V'; //방문한 O를 V로
        
        // 오른쪽
        dfs(board,i,j+1);    
        // 왼쪽
        dfs(board,i, j-1);
        // 아래
        dfs(board,i+1,j);
        // 위
        dfs(board,i-1,j);
    }
}