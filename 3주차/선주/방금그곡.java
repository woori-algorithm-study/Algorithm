import java.util.ArrayList;


class Solution {
    public String solution(String m, String[] musicinfos) {        
        String answer = "";
        ArrayList <String> neo_score = StrToList_score(m);
        int before_play_time = 0;
        Song[] songs = new Song[musicinfos.length];
        int i =0;
        for(String asong : musicinfos){
            String[] info = asong.split(",");
            songs[i++] = new Song(info[0], info[1], info[2], info[3]);
        }
       
         for(int x = 0; x<songs.length; x++){
             String playing = "";

             for(int y = 0; y<songs[x].playtime; y++){
                 playing += songs[x].score.get(y%songs[x].score.size());
            }
            ArrayList<String> played = StrToList_score(playing);

            if(playing.contains(m)){
                played.retainAll(neo_score);
                if(played.containsAll(neo_score)){
                    if(before_play_time < songs[x].playtime){before_play_time = songs[x].playtime;
                        answer = songs[x].title;}
                }
            }
        }
        return answer.equals("")? "(None)" : answer;
    }
    
    public ArrayList<String> StrToList_score(String sc){
         ArrayList<String> result = new ArrayList<>();
         for(String s : sc.split("")){
            if(s.equals("#")){result.set(result.size()-1, result.get(result.size()-1)+"#");}
            else result.add(s);
        }
        return result;
    }
    
    public class Song {
        String start;
        String end;
        int startH;
        int startM;
        int endH;
        int endM;
        int playtime;
        String title;
        ArrayList <String> score = new ArrayList<>();

        Song(String st, String en, String ti, String sc){
            this.start = st;
            this.end = en;
            this.startH = Integer.parseInt(st.substring(0,2));
            this.startM = Integer.parseInt(st.substring(3,5));
            this.endH = Integer.parseInt(en.substring(0,2));
            this.endM = Integer.parseInt(en.substring(3,5));    
            this.playtime =(endM - startM) + (endH - startH)*60;
            this.title = ti;
            this.score = StrToList_score(sc);
        }
    }
    
}

