import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//1260: 20916KB 344ms
public class Main {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> vertex;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine(); //4 5 1
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수
        int V = Integer.parseInt(st.nextToken()); //탐색 시작 번호

        vertex = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=N;i++){vertex.add(new ArrayList<Integer>());}//01234...N

        for(int x=0; x<M; x++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            vertex.get(a).add(b);
            vertex.get(b).add(a); //양방향 간선
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int node){
        visited[node] = true;
        System.out.print(node + " ");
        // 연결된 정점을 정렬( 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문)
        Collections.sort(vertex.get(node));//아 배열로 풀걸
        for(int nextNode : vertex.get(node)){//node와 연결된 정점 중에
            if(!visited[nextNode])dfs(nextNode); // 방문 하지 않은 노드만 방문처리
        }
    }

    public static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()) {//연결된 노드
            int currNode = queue.poll();//가장 앞의 노드 큐에서 제거
            System.out.print(currNode + " ");

            //현재 노드와 연결된 노드를 방문하지 않았으면 큐에 추가
            for(int nextNode : vertex.get(currNode)) {
                if(!visited[nextNode]) {
                    queue.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

    }
}
