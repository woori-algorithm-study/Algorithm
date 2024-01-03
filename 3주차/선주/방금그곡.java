import java.util.ArrayList;


class Solution {
    public String solution(String m, String[] musicinfos) {        
        String answer = "";
        //네오가 기억한 멜로디를 음계로 나누기 (Why? # 때문에 한 글자가 음계가 아님!!)
        ArrayList <String>  neo_score = new ArrayList<>();
        
        for(String s : m.split("")){//String => String[]
            if(s.equals("#")){neo_score.set(neo_score.size()-1, neo_score.get(neo_score.size()-1)+"#");} //#을 만나면 마지막 요소에 "#"을 붙여 변경
            else neo_score.add(s);//알파벳은 무조건 넣음
        }
        
        
        Song[] songs = new Song[musicinfos.length];
        //songs 배열에 Song 클래스 타입으로 정보 저장
        int i =0;
        for(String asong : musicinfos){
            String[] info = asong.split(",");
            songs[i++] = new Song(info[0], info[1], info[2], info[3]);
        }
       
        // contains()를 쓰기 위해서 songs[x].score 배열을 string으로 변환
        String neo_str = String.join("", neo_score);
        
        
        /**메인 로직**/
         for(int x = 0; x<songs.length; x++){ //x.length개 입력에 대해
             String playing = "";//재생 시간동안의 음표들
             //System.out.println(songs[x].playtime);
             for(int y = 0; y<songs[x].playtime; y++){//음악은 항상 처음부터 재생
                 playing += songs[x].score.get(y%songs[x].score.size());
                 //조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
                 //재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
                 if(playing.contains(neo_str)){answer =  songs[x].title;}
         }

        }
        //재생시간동안 모두 재생해도 neo가 기억하는 노래가 없음
           return "(None)";
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
    ArrayList <String> score = new ArrayList<>();
        
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
           
        for(String s : sc.split("")){
            if(s.equals("#")){score.set(score.size()-1, score.get(score.size()-1)+"#");}
            else score.add(s);
        }
       
    }
}
}

