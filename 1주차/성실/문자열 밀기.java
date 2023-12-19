class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        String C = A;
        
        for(int i = 0; i < C.length() ; i++) {
            
            if (C.equals(B)) {
                break;
            } else {
                char a = C.charAt(C.length()-1); // 맨 뒤 문자 잘라서 a에 넣음
                C = a + C.substring(0, C.length()-1); // 맨 뒤 문자 + 0부터 A.length-2 까지의 문자열
                answer += 1;   
            }  
        }
        
        if (answer >= C.length()) {
            return -1;
        } else {      
            return answer;
        }
    }
}
