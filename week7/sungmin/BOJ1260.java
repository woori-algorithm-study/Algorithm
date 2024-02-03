package week7.sungmin;

import java.util.*;
import java.io.*;
public class BOJ1260 {
    static StringTokenizer st;
    static int[][] arr;
    static boolean[] visited;
    static boolean[] visited2;
    static int M, N, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        visited2 = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1; // 모든간선에 1대입하여 연결
        }
        // System.out.println(Arrays.deepToString(arr));

        dfs(V);
        System.out.println();
        bfs(V);

    }

    public static void dfs(int v) {
        visited[v] = true;

        System.out.print(v + " ");
        for (int i = 1; i <= N; i++) {
            if (arr[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited2[v] = true;
        q.offer(v);

        while(!q.isEmpty()) {
            int x = q.poll();

            System.out.print(x + " ");
            for (int i = 1; i <= N; i++) {
                if (arr[x][i] == 1 && !visited2[i]) { 
                    visited2[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    
}
