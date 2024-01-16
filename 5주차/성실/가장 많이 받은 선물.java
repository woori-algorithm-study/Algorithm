import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] result = new int[friends.length]; // 선물 결과 담을 배열
        
        Map<String,Integer> map = new HashMap<>(); // gifts 정리 (같은 값 묶고 개수 세기)
        for(int i=0; i<gifts.length; i++) {
            map.put(gifts[i], map.getOrDefault(gifts[i], 0) +1);
        }
        
        
        Map<String,Integer> giveList = new HashMap<>(); // key : 준 사람, value : 횟수
        Map<String,Integer> takeList = new HashMap<>(); // key : 받은 사람, value : 횟수 
        
        for(int i=0; i<gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            giveList.put(gift[0], giveList.getOrDefault(gift[0], 0) +1);
            takeList.put(gift[1], takeList.getOrDefault(gift[1], 0) +1);
        }
    
        
        Map<String,Integer> giftNum = new HashMap<>(); // 선물 지수 - key : 사람, value 준횟수-받은횟수 
        
        for(int i=0; i<friends.length; i++) {
            giftNum.put(friends[i], giveList.getOrDefault(friends[i], 0) - takeList.getOrDefault(friends[i], 0));
        }

        // 다음날 선물 결과 계산
        for(int i=0; i<friends.length-1; i++) {
            for(int j=i+1; j<friends.length; j++) {
                int n1 = -1; // [i] -> [i+1] 횟수 담아줌
                int n2 = -1; // [i+1] -> [i] 횟수 담아줌
                String s1 = friends[i] + " " + friends[j];
                String s2 = friends[j] + " " + friends[i];

                if(map.get(s1) != null) {
                    n1 = map.get(s1); // i->j 횟수
                }  
                if(map.get(s2) != null) {
                    n2 = map.get(s2); // j->i 횟수
                } 
                
                
                // 서로 주고받은 경우
                if(n1 != -1 && n2 != -1) {
                    if (n1 > n2) result[i] += 1; // n1이 크면 인덱스i 친구에게 선물+1
                    else if (n1 < n2) result[j] += 1; // n2가 크면 인덱스j 친구에게 선물+1
                    else { // 주고받은 선물 횟수 같은 경우
                        if (giftNum.get(friends[i]) > giftNum.get(friends[j])) result[i] += 1;
                        else if (giftNum.get(friends[i]) < giftNum.get(friends[j])) result[j] += 1;
                        // 선물 지수 같은 경우는 처리x
                    }
                
                // 서로 주고받지 않은 경우
                } else if(n1 == -1 && n2 != -1) { // i는 안주고 j는 줌
                    result[j] += 1;           
                } else if(n1 != -1 && n2 == -1) { // i는 주고 j는 안줌
                    result[i] += 1;           
                } else if(n1 == -1 && n2 == -1) { // 서로 선물 x
                    if (giftNum.get(friends[i]) > giftNum.get(friends[j])) result[i] += 1;
                    else if (giftNum.get(friends[i]) < giftNum.get(friends[j])) result[j] += 1;
                    // 선물 지수 같은 경우는 처리x
                }
            }
        }

        // 최대값이 정답
        int max = Integer.MIN_VALUE;                                   
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
