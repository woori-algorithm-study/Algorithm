class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int remain = 0; // 나머지

        while (chicken >= 10) {
            remain += chicken % 10; // 1 + 8 + 0
            answer += chicken / 10; // 108 + 10 + 1 + 1
            chicken /= 10; // 108, 10, 1
            if (chicken < 10) {
                chicken += remain;
                remain = 0;
            }
        }
        
        return answer;
    }
}