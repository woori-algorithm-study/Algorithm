class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paint = -1; // 완료된 영역 담을 수
        
        for(int i : section) {
            if(i > paint) {
                paint = i + m - 1;
                answer++;
            } else continue;
        }        
        return answer;
    }
}
