import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2468 {
	// 2468: 18692KB 244ms
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로, 세로

        int max_height = 1;
        map = new int[N][N];
        for(int i = 0; i<N; i++){
                st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
                if(max_height < height){max_height = height;}
            }
        }

        int max_count = 0;
        for(int k = 0; k<=max_height; k++){ //이번 장마에서 k 이하는 물에 잠겨요
            visited = new boolean[N][N]; //이번 장마 전 방문 배열 초기화
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] > k && !visited[i][j]){
                        dfs(i, j, k);
                        cnt++;
                        if(cnt > max_count){max_count = cnt;}
                    }
                }
            }
        }

        System.out.println(max_count);

    }

    private static void dfs(int i, int j, int h) {
        visited[i][j] = true;
        for(int l = 0; l<4; l++){
            int ny = i + dy[l];
            int nx = j + dx[l];
            if(ny<0 || nx <0 || ny>=N || nx >=N){continue;}
            if(map[ny][nx] > h && ! visited[ny][nx]){
                dfs(ny, nx, h);
            }
        }
    }
}
