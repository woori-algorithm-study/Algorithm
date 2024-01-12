class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] painted = new int[n];//각 구역이 칠해진 횟수를 저장하는 배열
        
        for(int i=0; i < section.length; i++){
            
            if(painted[ section[i]-1 ] < 1){ //1. section의 구역이 칠해지지 않았으면
                
                for(int x = 0; x<m ; x++){ //롤러의 길이 만큼 (롤러가 닿는 구역)
                    
                    if((section[i]-1 +x) <n ){ //벽을 벗어나는 곳은 if로 처리 (indexOutRange)
                        
                        painted[section[i]-1 +x]++; //칠해진 횟수 증가
                    }
                }answer++;//롤러 사용 횟수 증가
            }
        }
        return answer;
    }
}
