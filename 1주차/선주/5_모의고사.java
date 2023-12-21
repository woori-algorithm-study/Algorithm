import java.util.ArrayList; //동적배열

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];//각자의 점수를 순서대로 저장
        //각자 찍는 답이 정답과 같으면 점수 증가
        for(int i = 0; i<answers.length; i++){
        if(answers[i] == one[i%one.length]){score[0]++;}  
        if(answers[i] == two[i%two.length]){score[1]++;}
        if(answers[i] == three[i%three.length]){score[2]++;}
        }
        //수포자 중에 1등 구하기
        int max =0;
        for(int x : score){
            if(max<=x){max=x;}
        }
        //1등들을 동적 배열에 추가
       for(int k=0; k<score.length; k++){
           if(max == score[k]){//각자의 점수가 최대값이면
               answer.add(k+1);//그 사람을 추가 k: index, k+1: 해당 one two three 번호
           }
       }    
        return answer.stream().mapToInt(i->i).toArray(); //ArrayList -> int[]
    }
}

/*
    빈 동적배열 생성: ArrayList<클래스> 변수명 = new ArrayList<>();
    for문의 인덱스를 다른 방법으로 활용할 수 있는지 생각하기
    score[] 배열 대신 변수 세개 사용하면 속도 향상 가능 : Later
    반복문 내부의 length도 계산의 일부임을 고려하기
*/
