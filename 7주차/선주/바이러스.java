import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 2606: 14216KB	132ms 
public class Main {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> links;
    static int com_cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        com_cnt = Integer.parseInt(bf.readLine()); // 컴퓨터의 개수
        int v_cnt = Integer.parseInt(bf.readLine()); // 간선 수

        visited = new boolean[com_cnt+1];
        links = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<=com_cnt; i++){links.add(new ArrayList<Integer>());}

        for(int i =0; i<v_cnt; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            links.get(a).add(b);
            links.get(b).add(a);
        }

        System.out.println(bfs());


    }

    public static int bfs(){
        int answer =0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int n : links.get(cur)){ // 이웃한 노드 탐색
                if(!visited[n]) {
                    q.offer(n);
                    answer++;
                    visited[n] = true;
                }
            }
        }
        return answer;
    }
}
