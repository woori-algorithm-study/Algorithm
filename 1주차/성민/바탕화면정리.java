import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        List<Integer> list = new ArrayList<>(); //행
        List<Integer> list2 = new ArrayList<>(); //열
        
        // 행  열  행+1  열+1
        // 위  왼  아래   오
        for (int i = 0; i < wallpaper.length; i++) {
            String s = wallpaper[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '#') {
                    list.add(i);
                    list2.add(j);
                }
            }
        }
        
        Collections.sort(list);
        Collections.sort(list2);

        answer[0] = list.get(0);
        answer[1] = list2.get(0);
        answer[2] = list.get(list.size()-1)+1;
        answer[3] = list2.get(list2.size()-1)+1;
        
        return answer;
    }
}