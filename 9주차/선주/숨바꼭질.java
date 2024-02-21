/*
1. 이동 가능 위치 : x+1, x-1, x*2
2. visit 하면서 몇 번째 탐색인지 카운트  : 이전 방문노드 + 1
3.  동생의 위치에 다다르면 마지막 위치 노드의 탐색 횟수 반환 : BFS 탐색이라서 리턴 값이 최단 시간이 됨.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] move = {1, -1}; // 현재 위치에 더할 값
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        System.out.println(bfs()-1); // 방문 안함 = 0으로 처리하기 위해 시작점에서 1부터 셈 : 처음 상태에선 0초 지남

    }

    private static int bfs() {
        int nx = 0;
        int x = N;
        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> visit = new HashMap<>(); // 노드 + 전체중 방문 회차
        visit.put(x, 1);
        q.addLast(N);
        while (!q.isEmpty()) {
            x = q.pollFirst();
            if(x<0 || x>100000) {continue;} //메모리 초과 방지
            if(x == K){return visit.getOrDefault(x, 0);} // 동생 찾았다!

            //1.좌 우 한칸 이동
            for (int i = 0; i < 2; i++) {
                nx = x + move[i];
                if (nx >= 0 && visit.getOrDefault(nx, 0) == 0) {
                    // 방문 처리 : 현재 방문 순서 =  이전 노드 방문 순서 + 1
                    visit.put(nx, visit.getOrDefault(x, 0) + 1);
                    q.addLast(nx);
                }
            }
            // 순간이동
            nx = x * 2;
            if (nx >= 0 && visit.getOrDefault(nx, 0) == 0) {
                // 방문 처리 : 현재 방문 순서 =  이전 노드 방문 순서 + 1
                visit.put(nx, visit.getOrDefault(x, 0) + 1);
                q.addLast(nx);
            }


        }
        return visit.getOrDefault(x, 0);
    }
}
