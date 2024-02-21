/*
visited가 전부 채워질때까지 정점 증가 시키면서 방문함수, return 되면 한개의 연결요소를 탐색한 것
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        graph = new int[N+1][N+1];
        visited = new boolean[N+1]; // 각 노드별 방문 여부

        for(int i = 0 ; i< M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        int answer = 0;
        for(int i = 1; i<=N;i++) {
                if(!visited[i]){
                    bfs(i);
                    answer++;
                }
        }

        System.out.println(answer);
    }

    private static void bfs(int s) {
        Deque<Integer> q = new LinkedList<>();
        q.addLast(s);

        //visted 여부 바꾸면서 탐색, bfs 호출 개수 세기
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[x][i] == 1) { // x 와 이웃한 노드 탐색
                    visited[i] = true;
                    q.addLast(i);
                }
                
            }
        }
    }
}
