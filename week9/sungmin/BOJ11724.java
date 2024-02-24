package week9.sungmin;

// 117360KB	524ms

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class BOJ11724 {
    static StringTokenizer st;
    static int map[][];
    static boolean visited[];
    static int answer, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }
        System.out.println(Arrays.deepToString(map));

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void bfs(int v){
        System.out.println("v: "+ v);
        Deque<Integer> q = new ArrayDeque<>();
        visited[v] = true;
        q.offerLast(v);

        while (!q.isEmpty()) {
            int x = q.pollFirst();

            for (int i  = 1; i <= N; i++) {
                if (map[x][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offerLast(i);
                }
            }
        }
    }
}
