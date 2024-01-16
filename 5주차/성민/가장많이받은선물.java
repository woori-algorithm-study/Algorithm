import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int[][] arr = new int[friends.length][friends.length]; // 주고 받은 표
        int[] arr2 = new int[friends.length]; // 선물지수
        
        for (int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            
            String A = s[0]; // 준 사람
            String B = s[1]; // 받은 사람
            for (int k = 0; k < friends.length; k++) {
                if (friends[k].equals(A)) {
                    arr2[k]++;
                }
                if (friends[k].equals(B)) {
                    arr2[k]--;
                }
            }
            
            int a = 0; // 행
            int b = 0; // 열
            for (int j = 0; j < friends.length; j++) {
                if (A.equals(friends[j])) {
                    a = j;
                    break;
                }
            }
            
            for (int j = 0; j < friends.length; j++) {
                if (B.equals(friends[j])) {
                    b = j;
                    break;
                }
            }
            arr[a][b]++;
        }
        // System.out.println(Arrays.deepToString(arr));
        // System.out.println(Arrays.toString(arr2));
        
        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (i == j) continue;
                
                if (arr[i][j] > arr[j][i]) {
                    cnt++;
                } else if (arr[i][j] == arr[j][i]) {
                    if (arr2[i] > arr2[j]) {
                        cnt++;
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }
        
        return answer;
    }
}