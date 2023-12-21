import java.util.*;

class Solution {
    public int solution(int n) {
        int jump = 0;
        
        while(n>0){
          if(n%2 !=0){jump++;}
          n = n/2; 
        }   
        return jump;
    }
}

/*
0. 테스트 케이스로 규칙 찾아보기 (답을 알려주니까)
1. 꼭 필요한 변수인지 생각하기
2. 횟수를 알고 있을때 for문, 횟수가 어떻게 될지 모를때는 while문 사용하기.
3. 반복문을 작성하기 전에 반복 시작 시점, 종료 시점 생각하기
*/
