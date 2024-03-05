import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int N;
    static int[][] map;
    static int[][] rain; // 비온뒤
    static Deque<int[]> dq;
    static boolean[] height = new boolean[101];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;
    static int answer = 1;
    // 아무 지역도 잠기지 않는다면 안전영역은 전체(=1)라서 기본 answer를 1로 설정해두었다

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                height[map[i][j]] = true;
            }
        }

        for (int i = 0; i < 101; i++) {
            if (height[i]) {
                check(i); // 잠길 수 있는 부분 확인해서 rain 배열 만들기
                //System.out.println(Arrays.deepToString(rain));
                count = 0;

                for (int j = 0; j < N; j++ ) {
                    for (int k = 0; k < N; k++) {

                        if (rain[j][k] == 1) {
                            dq.addLast(new int[] {j, k});
                            rain[j][k] = 0;
                            bfs();
                            count++;
                        }
                    }
                }
                answer = Math.max(answer, count);
            }
        }

        System.out.println(answer);
    }

    static void bfs() {
        while (!dq.isEmpty()) {
            int[] xy = dq.pollFirst();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (rain[nx][ny] == 1) {
                        dq.addLast(new int[] {nx, ny});
                        rain[nx][ny] = 0;
                    }
                }
            }
        }
    }

    static void check(int x) {
        // x 이하인 부분은 물에 잠긴다

        rain = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > x) rain[i][j] = 1; // 물에 안 잠기면 1로 표시
                else rain[i][j] = 0; // 물에 잠기면 0으로 표시
            }
        }
    }
}
