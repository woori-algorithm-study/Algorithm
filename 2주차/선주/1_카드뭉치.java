import java.util.Arrays;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int top1 = 0, top2 = 0;// 각 카드 스택의 맨 위 인덱스를 가리키는 변수
        String[] maden = new String[goal.length]; // goal을 탐색하면서 만들어지는 문장
        int md_idx = 0;
        for(int i = 0; i<goal.length; i++){
            //goal을 탐색하면서 goal 문장이 만들어 질때까지
            //String[] this_top = {cards1[top1], cards2[top2]};
            if(top1<cards1.length && goal[i].equals(cards1[top1]) ){maden[md_idx++] = cards1[top1++];}
            if(top2<cards2.length && goal[i].equals(cards2[top2])){maden[md_idx++] = cards2[top2++];}
            //아래 주석을 해제해서 만들어지는 문자열을 확인할 수 있다.
            //for(String str : maden){System.out.println(str);}
            if(Arrays.equals(goal, maden)){answer = "Yes";}
        }
        return answer;
    }
}
