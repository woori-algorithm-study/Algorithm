import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N; // 세로
    static int M; // 가로
    static int[][] map; // 지도
    static int[][] virus; // 바이러스 지도
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //System.out.println(Arrays.deepToString(map));

        dfs(0);
        System.out.println(answer);

    }


    static void dfs(int wall) { // 벽 세우는 경우의 수
        if (wall == 3) {
            bfs(); // 벽이 3개 세워지면 바이러스 퍼지는거 확인
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }


    static void bfs() { // 바이러스 퍼지는거 확인
        Deque<int[]> dq = new ArrayDeque<>();
        virus = new int[N][M]; // bfs 새로 들어올때마다 초기화됨

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus[i][j] = map[i][j];
                if(virus[i][j] == 2) {
                    dq.addLast(new int[] {i, j});
                }
            }
        }

        while (!dq.isEmpty()) {
            int[] xy = dq.pollFirst();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (virus[nx][ny] == 0) {
                        dq.addLast(new int[]{nx, ny});
                        virus[nx][ny] = 2;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus[i][j] == 0) {
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);
    }
}
