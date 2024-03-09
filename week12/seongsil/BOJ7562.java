import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {2, 1, 2, 1, -2, -1, -2, -1};
    static int[] dy = {1, 2, -1, -2, -1, -2, 1, 2};
    static int T; // 테스트케이스 수
    static int L; // 체스판 길이
    static int[][] chess; // 체스판
    static Deque<int[]> dq;
    static int startX; // 현재 칸 x
    static int startY; // 현재 칸 y
    static int endX; // 이동하려는 칸 x
    static int endY; // 이동하려는 칸 y
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        int n = 0;
        while (n < T) {
            L = Integer.parseInt(br.readLine());
            chess = new int[L][L];
            dq = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            dq.addLast(new int[] {startX, startY}); // 시작 칸 큐에 넣기
            chess[startX][startY] = 1;

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            if (startX == endX && startY == endY) {
                count = 0;
            } else {
                bfs();
                count = chess[endX][endY] -1;
            }

            System.out.println(count);
            n++;
        }
    }

    static void bfs() {
        while (!dq.isEmpty()) {
            int[] xy = dq.pollFirst();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < L && ny >= 0 && ny < L) {
                    if (chess[nx][ny] == 0) {
                        chess[nx][ny] = chess[x][y] + 1;
                        dq.addLast(new int[] {nx, ny});

                        if (chess[endX][endY] != 0) return;
                    }
                }
            }
        }
    }
}
