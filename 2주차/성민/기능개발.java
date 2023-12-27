import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            if ((100-progresses[i]) % speeds[i] == 0) {
                q.offer((100-progresses[i]) / speeds[i]);
            } else {
                q.offer((100-progresses[i]) / speeds[i] + 1);
            }
        }
        System.out.println(q);
        
        int x = q.poll();
        int cnt = 1;
        while (!q.isEmpty()) {
            if (x >= q.peek()) {
                cnt++;
                q.poll();
            } else {
                list.add(cnt);
                cnt = 1;
                x = q.poll();
            }
        }
        list.add(cnt);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}