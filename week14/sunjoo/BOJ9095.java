import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9095 {
    // 14220KB	124ms
    private static int T, N;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N+1]; // //1-Based 배열

            for (int j = 1; j <= N; j++) { //1-Based 배열 : 1부터 N인덱스 까지 (인덱스와 정수 N을 동일하게 봄.)
                if(j==1){
                    dp[j] = 1;
                }else if (j==2) {
                    dp[j] = 2;
                }else if (j==3) {
                    dp[j] = 4;
                }else{
                    /*
                    dp[j] = 1,2,3의 합으로 j를 만드는 경우의 수
                    = dp[j-1] 1,2,3의 합으로 j-1을 만드는 경우의 수 (N-1 + 1 = N)
                    + dp[j-2] 1,2,3의 합으로 j-2를 만드는 경우의 수 (N-2 + 2 = N)
                    + dp[j-3] 1,2,3의 합으로 j-3을 만드는 경우의 수 (N-3 + 3 = N)
                    */
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
	                  //N을 만들기 위해서는 N-1에서 1을 만드는 경우와, N-2에서 2를 더해 만드는 경우와, N-3에 3을 더해만드는 경우가 있다.
                }
            }
            System.out.println(dp[N]);
        }
    }
}
