import java.util.HashMap;
/*HashMao : 중복을 허용하지 않고, key,value 쌍으로 저장, 리스트보다 속도가 빠름
* getOrDefault메서드로 현재 값이 없으면 초기화를, 값이 있으면 수정을 할 수 있음
*/
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> p = new HashMap();
        for (String pa : participant){
            p.put(pa,   p.getOrDefault(pa, 0) + 1); //없으면 0, 있으면 1추가
        }
        for (String co : completion){
            //put - 키가 이미 존재하는 경우 매핑되는 값이 변경
            p.put(co,   p.get(co) - 1);
        }
        //단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
        for (String key : p.keySet()) {
            if (p.get(key) > 0){//모든 키를 통해 값을 탐색 중에 해당 선수가 통과하지 않았으면
                answer = key;
            }
        }
        return answer;
    }
}
