import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2206 {
    // 	112660KB 948ms
    static int N;
    static int M;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로 : 6
        N = Integer.parseInt(st.nextToken()); // 가로 : 4
        map = new int[M][N]; // x,y
        visited = new int[M][N][2]; // x, y, crashed

        for (int i = 0; i < M; i++) {
            String line = bf.readLine();
            for(int j = 0; j< N; j++){
                map[i][j] = line.charAt(j) - 48;
            }
        }


        System.out.println(bfs(0,0, 0)); // (0,0) 에서 부수지 않은 경우부터 출발; 매개변수 없어도 됨 (표시용)

    }

    private static int bfs(int x, int y, int crashed) {
        int nx;
        int ny;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(x);
        q.addLast(y);
        q.addLast(crashed);
        visited[x][y][crashed] = 1;
        while(!q.isEmpty()){
            int cx = q.pollFirst();
            int cy = q.pollFirst();
            int ccrashed = q.pollFirst();
            if(cx == M-1 && cy == N-1) {return visited[cx][cy][ccrashed];}
            for (int i = 0; i < 4; i++) {
                nx = cx+dx[i];
                ny = cy+dy[i];
                if(ny<0 || nx<0 || ny>=N || nx >=M){continue;}
                if(map[nx][ny] == 0 && visited[nx][ny][ccrashed] == 0){ // 일반 통로
                    q.addLast(nx);
                    q.addLast(ny);
                    q.addLast(ccrashed);
                    visited[nx][ny][ccrashed] = visited[cx][cy][ccrashed] + 1;
                }else if (map[nx][ny] == 1 && visited[nx][ny][ccrashed] == 0) { //이 벽 안뚫어봤는데...
                    if (ccrashed == 0) { // 뚫을 수 있지 않을까?
                        q.addLast(nx);
                        q.addLast(ny);
                        q.addLast(1);
                        visited[nx][ny][1] = visited[cx][cy][ccrashed] + 1;
                    }
                }
            }
        }
        return -1;
    }

}
