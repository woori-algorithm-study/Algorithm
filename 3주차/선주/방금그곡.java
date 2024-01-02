import java.util.ArrayList;
class Solution {
    public String solution(String m, String[] musicinfos) {
        //네오가 기억한 멜로디와 악보에 사용되는 음
        //String [] neo = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#","B"};
        
        
        //네오가 기억한 멜로디를 음계로 나누기 (# 때문에 한 글자가 음계가 아님!!)
        int j = 0;
        String[] neo = new String[m.length()];//length?? #개수만큼 적어야하는데... null null하당...
        for(String s : m.split("")){//String => String[]
            if(s.equals("#")){neo[j-1] = (neo[j-1]+"#");} //#을 만나면 이전요소 값은 "이전요소+#"으로 변경
            else neo[j++] = s;
        }
        
        
        Song[] songs = new Song[musicinfos.length];
        //songs 배열에 Song 클래스 타입으로 정보 저장
        int i =0;
        for(String asong : musicinfos){
            String[] info = asong.split(",");
            songs[i++] = new Song(info[0], info[1], info[2], info[3]);
        }
        
        /**메인 로직**/
        //1. neo가 포함되는 song 찾기
        //2. 각 song을 재생시간 동안 반복해 돌면서 neo가 포함되는지 확인
        for(int x = 0; i<songs.length; i++){
            for(int y = 0; j<songs[x].playtime; j++){//음악은 항상 처음부터 재생,
                //아! 너무 늦었어....! ㅜㅜ
                //쉬는시간에도 못풀면 답 보고 마저 풀이할 예정..
            }
        }
        String answer = "";
        return answer;
    }
    //Song 클래스 정의
    public class Song {
    String start;
    String end;
    int startH;
    int startM;
    int endH;
    int endM;
    int playtime;
    String title;
    String score_str;
    //String [] score =  new String[this.score_str.length()];//"main" java.lang.NullPointerException
    String [] score;
        
    Song(String st, String en, String ti, String sc){//나중에 필요없는 변수 수정
        this.start = st;
        this.end = en;
        this.startH = Integer.parseInt(st.substring(0,2));
        this.startM = Integer.parseInt(st.substring(3,5));
        this.endH = Integer.parseInt(en.substring(0,2));
        this.endM = Integer.parseInt(en.substring(3,5));    
        this.playtime =(endM - startM) + (endH - startH)*60;
        this.title = ti;
        
        this.score_str = sc;
        int j = 0;
        score = new String[this.score_str.length()];
        for(String s : sc.split("")){
            if(s.equals("#")){this.score[j-1] = (this.score[j-1]+"#");}
            else this.score[j++] = s;
        }
       
    }
}
}

