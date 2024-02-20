import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int N;
    static int K;
    static int[] position = new int[100001];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        if (N != K) {
            check();
        }

        System.out.println(answer);

    }

    static void check() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(N);
        position[N] = 1;

        while (!dq.isEmpty()) {
            int x = dq.pollFirst();

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = x - 1;
                } else if (i == 1) {
                    nx = x + 1;
                } else {
                    nx = 2 * x;
                }

                if (nx >= 0 && nx < position.length && position[nx] == 0) {
                    dq.addLast(nx);
                    position[nx] = position[x] + 1; // 이전값에 1씩 더해주기
                }
            }

            if (position[K] != 0) {
                answer = position[K] - 1; // 처음값 N 위치를 1로 시작했기 때문에 최종답은 1 빼줘야함
                return;
            }
        }
    }
}
