import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";        
        String[] sheet; // 악보 나눠서 담을 배열
        String[] result = {"","0"}; // m이 포함된다면(조건 만족) [제목, 재생 시간] 넣어주기
        
        m = m.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
        
        for(int i=0; i<musicinfos.length; i++) { // 한 곡씩 정보 확인
            
            String[] musicinfo = musicinfos[i].split(","); // [시작, 끝, 제목, 악보]
            
            // 음악 재생 시간 계산
            String[] start = musicinfo[0].split(":"); // 시작시간 : [시, 분]
            String[] end = musicinfo[1].split(":"); // 끝시간 : [시, 분]
            int h = Integer.parseInt(end[0]) - Integer.parseInt(start[0]); // '시' 차이
            int play = (h * 60 + Integer.parseInt(end[1])) - Integer.parseInt(start[1]); // 재생 시간
            
            
            musicinfo[3] = musicinfo[3].replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
            
            
            // 재생 시간만큼 악보 늘려주기 = 재생되는 악보
            int n = 0; // 악보 인덱스
            String music = ""; // 재생되는 악보
            for(int j=0; j < play; j++) {
                music += musicinfo[3].charAt(n);
                n++;
                n = n % musicinfo[3].length();
            }
                        
            // 조건 만족하는지 확인
            if(music.contains(m)) {
                
                // 재생 시간 비교해서 더 크면 새로운 음악으로 바꿔주고 
                // 같거나(같을 경우 먼저 입력된게 정답이라서) 작으면 이전 데이터 유지
                if(play > Integer.parseInt(result[1])) {   
                    result[0] = musicinfo[2];
                    result[1] = Integer.toString(play);
                }
            }
        }
        
        if (result[0].equals("")) {
            answer = "(None)";
        } else {
            answer = result[0];
        }
        
        return answer;
    }
}
