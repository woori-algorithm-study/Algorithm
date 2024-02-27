import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 7576: 114876kb	664ms
		// LinkedList -> : 147820kb	720ms
    private static int N;
    private static int M;
    private static int[][] Box;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
      
        // 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
        M = Integer.parseInt(st.nextToken());// 가로
        N = Integer.parseInt(st.nextToken());// 세로
        Box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j =0; j<M; j++){
                int cell = Integer.parseInt(st.nextToken());
                Box[i][j] = cell;
            }
        }
      
        dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Box[i][j] == 1) {
                    dq.addLast(i);
                    dq.addLast(j);
                }
            }
        }
      
        bfs();
        int maxDate = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if(Box[j][k] == 0){
                    System.out.println(-1); return;
                }
                if(maxDate< Box[j][k]){maxDate = Box[j][k];}
            }

        }
        System.out.println(maxDate-1);
    }

    private static void bfs() {

        while (!dq.isEmpty()) {
            int by = dq.pollFirst();
            int bx = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int ny = by + dy[i];
                int nx = bx + dx[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) {continue;}
                if(Box[ny][nx] == 0){
                    Box[ny][nx] = Box[by][bx] + 1;
                    dq.addLast(ny);
                    dq.addLast(nx);
                }

            }
        }
    }
}
