import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        int count = 0;
        for(int i = 1; i < N+1; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(int x) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(x);
        visited[x] = true;

        while (!dq.isEmpty()) {
            int point = dq.pollFirst();

            for(int i = 1; i < N+1; i++) {
                if(graph[point][i] == 1 && !visited[i]) {
                    dq.addLast(i);
                    visited[i] = true;
                }
            }
        }
    }
}
