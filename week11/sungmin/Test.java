package week11.sungmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    private static int N;
    private static Map<Integer, ArrayList<Integer>> tree;
    private static int [] parents;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //노드의 개수

        tree = new HashMap<>(); // 노드 : 이웃한 노드
        for (int i = 1; i <= N; i++) { // null 방지
            tree.put(i, new ArrayList<Integer>());
        }

        parents = new int[N+1]; // 인덱스 번호의노드 : 부모노드


        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        System.out.println(tree);

        bfs();
        for (int i = 2; i <=N; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void bfs() {
        Deque<Integer> q = new ArrayDeque<>(); // 연결된 노드 부모를 확인하는 대기열
        q.addLast(1);
        while (!q.isEmpty()) {
            int n = q.pollLast();
            System.out.println("n = " + n);
            for (int x : tree.get(n)) { // 노드 n의 이웃 노드들
                System.out.println("x = " + x);
                if(x == 1){continue;} // 1은 루트 노드라서 엄마 없음

                if(parents[x] == 0){ //아직 엄마 찾는 노드이면
                    parents[x] = n; //x는 엄마 n을 찾았어요
                    System.out.println(Arrays.toString(parents));
                    q.addLast(x);//다음엔 x라도 엄마 못찾은 친구를 찾아요
                }

            }

        }
    }
}