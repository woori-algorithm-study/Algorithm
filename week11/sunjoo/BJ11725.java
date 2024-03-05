import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11725 {
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //노드의 개수

        Map<Integer, Integer> map = new HashMap<>(); // 노드 : 부모노드
        map.put(1, 1); //루트 노드

        Deque<Integer> q = new ArrayDeque<>(); //미아 보호소

        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(map.getOrDefault(a, 0) != 0){ // a가 이미 있을 때
                map.put(b, a); //b의 부모는 a
            }else if(map.getOrDefault(b, 0) != 0) { //b가 이미 있을 때
                map.put(a, b); //a의 부모는 b

            }else{ //둘 다 없을 때 : 새로운 트리가 따로 똑 떨어져 작성됨
                q.addLast(a);
                q.addLast(b);
            }
        }

        while (!q.isEmpty()){
            int a = q.pollFirst();
            int b = q.pollFirst();

            if(map.getOrDefault(a, 0) != 0){ // a가 이미 있을 때
                map.put(b, a); //b의 부모는 a
            }else if(map.getOrDefault(b, 0) != 0) { //b가 이미 있을 때
                map.put(a, b); //a의 부모는 b

            }else{ //둘 다 없을 때 : 새로운 트리가 따로 똑 떨어져 작성됨
                q.addLast(a);
                q.addLast(b);
            }
        }

        for(int i = 2; i<=N; i++){
            System.out.println(map.get(i)); //각 노드의 부모 출력
        }



    }
}
