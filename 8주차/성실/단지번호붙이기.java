import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0; // 단지 내 집의 수
    static List<Integer> home; // count 모아줄 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        home = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    check(i, j);
                    home.add(count);
                }
                count = 0;
            }
        }
        Collections.sort(home);
        
        System.out.println(home.size());
        for(int i = 0; i < home.size(); i++) {
            System.out.println(home.get(i));
        }
    }
    
    static void check(int x, int y) {
        count++;
        map[x][y] = 0;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(map[nx][ny] == 1) check(nx, ny);
            }
        }
        
    }
}
