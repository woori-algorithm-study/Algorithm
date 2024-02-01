class Solution {
    //상,하,좌,우, 좌상, 우상, 좌하, 우하
    private static final int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    int x;
    int y;
    public boolean[][] visited;
    public boolean [][] map;
    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length];//false로 초기화
        map = new boolean[board.length][board.length]; //위험구역 여부을 저장하는 bool
        int answer = 0;
        int len = board.length;
        
        for(int oy = 0; oy<board.length; oy++){
                dfs(0, oy, board);
        }
        
        for(int y=0; y<board.length; y++){
            for(int x=0; x<board.length; x++){
                if(map[y][x]){continue;}
                else{answer++;}
            }
        }
        
        return answer;
    }

    private void dfs(int x, int y, int[][]board){
        visited[y][x] = true;
        if(board[y][x] == 1){map[y][x] = true;} //! 중요 : 테스트케이스 9번: [[1]] 일때 처음 dfs에 진입한 (x: 0, y:0)에 대해서도 map을 체크해줘야함.                 
        for(int ox = 0; ox<board.length; ox++){
          
            for(int i=0; i<4; i++){//지뢰 구역
                this.x = ox+dx[i];
                this.y = y+dy[i];
                if(this.x>-1&& this.x<board.length && this.y>-1&&this.y<board.length && !visited[this.y][this.x]){
                    if(board[this.y][this.x] == 1){
                        map[this.y][this.x] = true;
                      
                        for(int a=0; a<8; a++){//위험 구역
                            int ax = this.x + dx[a];
                            int ay = this.y + dy[a];
                            if(ax >-1&& ax<board.length && ay>-1&&ay<board.length){
                                map[ay][ax] = true; 
                            }
                        }//for(0~8)
                      
                        dfs(this.x, this.y, board);
                    }
                }
            }//for(0~4)
          
        }//for(x~n)
        return;
    }
}