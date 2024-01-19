import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int len = friends.length;
        HashMap<String, Integer> idxMap = new HashMap(); //  이름 , 선물지수
        HashMap<String, Integer> fList = new HashMap(); //이름, friends배열에서의 인덱스;
        int[][] gt = new int[len][len];
        //누가 누구에게 몇개
        int x = 0;
        for(String a : friends){fList.put(a,x++);}
        //friends 읽으면서
        for(int i = 0; i<len; i++){
            String f = friends[i];
            //f의 선물지수는 무엇인지, 선물을 주고 받은 내용 저장
            for(String g : gifts){//gifts 읽으면서
                String[] arr = g.split(" ");
                if(arr[0].equals(f)){//f가 준 사람이면
                    idxMap.put(f, idxMap.getOrDefault(f,0) +1);//f의 선물지수 올리기
                    gt[i][fList.get(arr[1])]++;
                }
                if(arr[1].equals(f)){//f가 받은 사람이면
                    idxMap.put(f, idxMap.getOrDefault(f,0) -1);//f의 선물지수 내리기
                }
            }
        }
        
        //두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
        
        int maxCnt = 0;
        for(int b=0; b<len; b++){
            String ff = friends[b];
            int fCnt = 0;
            for(int c=0; c<len; c++){
                //System.out.print(gt[b][c]);
                if(gt[b][c] > gt[c][b]){//두 사람이 선물을 주고받은 기록이 있다면,
                    //이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음달에 선물을 하나 받는다.
                    System.out.println(ff+"가"+ friends[c]+ "에게 더 많이 줌");
                    fCnt++;
                }else if(gt[b][c] == gt[c][b]){//두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면,
                    // 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    //만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
                    if(idxMap.getOrDefault(ff,0) > idxMap.getOrDefault(friends[c],0)){fCnt++; System.out.println(ff+"가"+ friends[c]+ "보다 선물지수가 더 높음");}
                }
            }
            if(fCnt > maxCnt){maxCnt = fCnt;}
        }
            //System.out.println();
    
        
         // for(String i : idxMap.keySet()){ //저장된 선물지수값 확인
         //     System.out.println("[Key]:" + i + " [Value]:" + idxMap.get(i));
         // }
        return maxCnt;
    }
}
