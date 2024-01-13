import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0)-1);
        }
        // System.out.println(map);
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (map.get(key) > 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}