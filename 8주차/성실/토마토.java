import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int M; // 상자 가로 칸, y
    static int N; // 상자 세로 칸, i
    static int[][] box;
    static int count = 0; // 입력할때 0이 있는지 없는지 확인하는 용도
    static Deque<int[]> q = new ArrayDeque<>();
    static int max = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) q.addLast(new int[]{i, j});
                else if (box[i][j] == 0) count++;
            }
        }

//        System.out.println(Arrays.deepToString(box));
//        System.out.println(count);
//        while(!q.isEmpty()) {
//            int[] qq = q.poll();
//            System.out.println(Arrays.toString(qq));
//        }

        if(count != 0) { // count = 0 이면 전체가 익어있는 상태라서 확인할 필요가 없음 -> result = 0
            bfs();

            loop:
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {

                    if(box[i][j] == 0) { // bfs 돌고왔는데 0 남아있으면 안 익은게 남아있다면
                        result = -1;
                        break loop; // 결과를 -1로 만들고 종료

                    } else {
                        result = max - 1; // 처음에 2부터 넣었기 때문에 최종답은 max-1 해야됨
                    }
                }
            }
        }

        System.out.println(result);
    }

    static void bfs() {

        while (!q.isEmpty()) {
            int[] xy = q.pollFirst();
            int x = xy[0];
            int y = xy[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >=0 && ny < M) {
                    if(box[nx][ny] == 0) {
                        box[nx][ny] = box[x][y] + 1; // 주변을 +1씩 해주기
                        q.addLast(new int[]{nx, ny}); // 큐에 넣어주기

                        max = Math.max(max, box[nx][ny]);
                    }
                }
            }
        }
    }
}
