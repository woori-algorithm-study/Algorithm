import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    //14200KB	120ms
    private static int stairCount;
    private static int[] stairs, dp1, dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairCount = Integer.parseInt(br.readLine());
        //stairs = dp1 = dp2 = new int[stairCount+1]; // N+1개 요소를 가지는 1-Based배열임 (<-근데 이렇게 적으면 안됨: 참조변수라 주소 복사)
        stairs = new int[stairCount+1]; // n번째 계단의 점수,
        dp1 = new int[stairCount+1]; // 1칸 올라서 n번째 계단을 밟았을 때 받을 수 있는 최대 점수
        dp2 = new int[stairCount+1]; // 2칸 올라서 n번째 계단을 밟았을 때 받을 수 있는 최대 점수

        for(int i = 1; i <= stairCount; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i<= stairCount; i++){
            if(i == 1){
                dp1[i] = stairs[1]; // 시작 -> 1번째 계단
            }
            else if(i == 2){
                dp1[i] = dp1[i-1] + stairs[2]; // (시작-> 1번째) -> 2번째
                dp2[i] = stairs[2]; // 시작 -> 2번째
            }
            /*else if(i==3){
                dp1[i] = dp1[i-1] + stairs[3];
                dp2[i] = (dp1[i-2] || dp2[i-2]) + stairs[3];
            }*/
            else {
                dp1[i] = dp2[i - 1] + stairs[i];
                dp2[i] = Math.max(dp1[i - 2], dp2[i - 2]) + stairs[i];
            }
        }
        System.out.println(Math.max(dp1[stairCount], dp2[stairCount]));


        // 연속된 3개의 계단을 밟아서는 안된다. =  1칸 오르고 나면 무조건 2칸 올라야 한다.
        // d1[i] = dp1[i-1] + stairs[i]; //1칸 올라서 n번째 계단을 밟을때 점수 = (1칸 올라서) n-1번째 계단을 밟았을 때 점수 + n 번째 계단의 점수
        // d2[i] = max(dp1[i-2], dp2[i-2]) + stairs[i];
        // 2칸 올라서 n번째 계단을 밟을 때 최대 점수 =
        // 1. (1칸 올라서) n-2번째 계단을 밟았을 때 점수 + n번째 계단의 점수
        // 2. (2칸 올라서) n-2번째 계단을 밟았을 때 점수 + n번째 계단의 점수

    }
}
