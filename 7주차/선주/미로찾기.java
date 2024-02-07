import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//16052KB	156ms 2302B
public class Main {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    static int[][] maze;
    static int[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken()); //줄의 개수
        M = Integer.parseInt(st.nextToken()); //미로 가로 M개 정수
        maze = new int[N][M];
        visited = new int[N][M];

        //미로 배열 저장
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(bf.readLine());
            String s1 = st.nextToken();
            for (int x = 0; x < M; x++) {
                maze[y][x] =  Integer.parseInt(String.valueOf(s1.charAt(x)));
            }
        }
        Node startNode = new Node(0,0);
        bfs(startNode);
        System.out.println(visited[N-1][M-1]); //M,N에 도착했을 때

    }
        public static void bfs (Node node){
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            visited[node.y][node.x] = 1;

            while (!queue.isEmpty()) {//연결된 노드
                Node curNode = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Node nextNode = new Node(curNode.y + dy[i], curNode.x + dx[i]);

                    //현재 노드와 연결된 노드를 방문하지 않았으면 큐에 추가
                    if (nextNode.y>=0 && nextNode.y<N && nextNode.x>=0 && nextNode.x<M && visited[nextNode.y][nextNode.x] == 0 && maze[nextNode.y][nextNode.x] == 1) {
                        queue.offer(nextNode);
                        visited[nextNode.y][nextNode.x] = visited[curNode.y][curNode.x] +1 ;
                    }
                }
            }

        }

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
