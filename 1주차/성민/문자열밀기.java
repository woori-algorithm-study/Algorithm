class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int idx = 0; //A길이 만큼만 반복
        
        if (A.equals(B)) {
            return 0;
        }
        
        while (true) {
            String s = "";
            idx++;
            char tmp = A.charAt(A.length()-1); //마지막 문자
            s += tmp;
            
            for (int i = 0; i < A.length()-1; i++) {
                s += A.charAt(i);
            }
            answer++;
            
            if (s.equals(B)) {
                break;
            }
            if (idx == A.length()) {
                return -1;
            }
            A = s;
        }
        
        
        return answer;
    }
}