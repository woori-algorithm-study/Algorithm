import java.util.ArrayList;


class Solution {
    public String solution(String m, String[] musicinfos) {        
        String answer = "";
        System.out.println("네오 : "+m);    
        
        //네오가 기억한 멜로디를 음계로 나누기 (Why? # 때문에 한 글자가 음계가 아님!!)
        ArrayList <String> neo_score = StrToList_score(m);
        
        
        Song[] songs = new Song[musicinfos.length];
        //songs 배열에 Song 클래스 타입으로 정보 저장
        int i =0;
        for(String asong : musicinfos){
            String[] info = asong.split(",");
            songs[i++] = new Song(info[0], info[1], info[2], info[3]);
        }
       

        
        /**메인 로직**/
         for(int x = 0; x<songs.length; x++){ //x.length개 입력에 대해
             System.out.println("========="+x+"번째 입력=========");
             String playing = "";
             for(int y = 0; y<songs[x].playtime; y++){//음악은 항상 처음부터 재생
                 playing += songs[x].score.get(y%songs[x].score.size()); //재생 시간동안의 음표들
            }
            ArrayList<String> played = StrToList_score(playing);
            System.out.print("재생 : ");for(String ss : played){System.out.print(ss);}System.out.println();
             
            
            /*1. 문자열 비교만 했을 때 : #을 무시하고 같게 비교하기 때문에 실패.
            *=> if(playing.contains(neo_str)){answer = songs[x].title;}
            *반례:
            *HELLO 안에 있는 ABC#은 기억한 멜로디인 ABC와 일치하지 않고,
            *WORLD 안에 있는 ABC가 기억한 멜로디와 일치한다.

            2. 배열 A와 B 사이 배열 A에 B가 포함 : A와 B의 교집합이 B
            *라고 생각했는데 이 경우에는 순서를 보장하지 않음...
            *그러면 문자열 포함 통과, 교집합이 네오가 기억한 곡과 같은지 통과 하면 될까?
            *뭔가 반례가 있을거 같지만..... 일단 해보자 ㅜ
            ***played.retainAll(neo_score);//좌 -(우에 포함되지 않는 모든 원소)
            ***played.containsAll(neo_score)//좌가 우를 포함하는지 확인(교집합의 결과가 같은지?)
            */
             
            if(playing.contains(m)){
                System.out.println("문자 통과");
                played.retainAll(neo_score);
                
                if(played.containsAll(neo_score)){
                System.out.print("교집합: "); for(String ss : played){System.out.print(ss);}System.out.println();
                return songs[x].title;
                }
            }
        }
        //재생시간동안 모두 재생해도 neo가 기억하는 노래가 없음
        return "(None)";
    }
    
    //문자열 악보를 음계단위의 요소를 가지는 리스트로 바꾸는 메서드
    public ArrayList<String> StrToList_score(String sc){
         ArrayList<String> result = new ArrayList<>();
         for(String s : sc.split("")){//String => String[]
            //#을 만나면 마지막 요소에 "#"을 붙여 변경
            if(s.equals("#")){result.set(result.size()-1, result.get(result.size()-1)+"#");}
            else result.add(s);//알파벳은 무조건 넣음
        }
        return result;//음계끼리 구분된 악보 리스트 반환
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
        }//constroctor
    }//class Song
    
}//class Solution

