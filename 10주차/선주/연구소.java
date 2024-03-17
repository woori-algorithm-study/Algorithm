import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    // 104252KB 404ms
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int N, M;
    static int maxSafeZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0, 0, 0);

        System.out.println(maxSafeZone);
    }

    static void makeWall(int wallCnt, int start_x, int start_y) {
        //벽이 3개가 설치 된 경우 bfs 탐색 시작
        if(wallCnt == 3) {
            bfs();
            return;
        }
        // 탐색을 이미 했던 우측 하단에 대해서 제외하기 위해 반복문 시작점 설정
        for(int i=start_x; i<N; i++) {
            for(int j= (i == start_x) ? start_y : 0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(wallCnt+1, i, j);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Deque<Cell> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2){ // 바이러스 시작점
                    q.addLast(new Cell(i, j));
                }
            }
        }


        int[][] cpMap = new int[N][M]; // 함수 내부마다 다른 배열 주소를 참조시킴 : 원본과 격리
        for (int i = 0; i < N; i++) {
            cpMap[i] = map[i].clone();
        }

        while (!q.isEmpty()){
            Cell current = q.pollFirst();
            int cx = current.x;
            int cy = current.y;

            for(int d =0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(nx<0 || ny<0 || nx>= N|| ny>=M || cpMap[nx][ny] != 0){continue;} // 바이러스가 퍼질 수 있는 공간이면

                q.addLast(new Cell(nx, ny));
                cpMap[nx][ny] = 2;
            }
        }
        findSafeZone(cpMap);
    }

    private static void findSafeZone(int[][] cpMap) {
        int safeZone = 0;
        for(int i=0; i<N ; i++) {
            for(int j=0; j<M; j++) {
                if(cpMap[i][j] == 0) {safeZone++;}
            }
        }
        if (maxSafeZone < safeZone) {maxSafeZone = safeZone;}
    }

    static class Cell {
        int x;
        int y;

        Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
