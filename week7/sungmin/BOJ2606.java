package week7.sungmin;

import java.io.*;
import java.util.*;

public class BOJ2606 {
    static int[][] map;
    static boolean[] visited;
    static int N, M;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map[a][b] = map[b][a] = 1;
        }
        // System.out.println(Arrays.deepToString(map));

        bfs(1);
        System.out.println(answer);
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.offer(v);

        while(!q.isEmpty()) {
            int x = q.poll();
            
            for (int i = 1; i <= N; i++) {
                if (map[x][i] == 1 && !visited[i]) {
                    answer++;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        
    }
}
