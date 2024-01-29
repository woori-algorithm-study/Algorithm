class Solution {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    boolean[][] visited;
    
    public int solution(int[][] board) {
        int answer = 0;
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    check(i, j);
                }
            }
        }
        
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(visited[i][j] == true) {
                    count++; // true 개수 세기
                }
            }
        }
        answer = (board.length * board.length) - count;
        return answer;
    }
    
    void check(int x, int y) {
        visited[x][y] = true; // 1인 곳 true 표시
        
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=0 && nx<visited.length && ny>=0 && ny<visited.length) {
                visited[nx][ny] = true; // 지뢰 근처 전부 true 표시
            }
        }
        
        
    }
}
