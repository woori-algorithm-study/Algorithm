class Solution {
    public int solution(String A, String B) {
        int toRightCnt = 0;
        boolean there = false;
        String A_copy = A;
        
        for(int i=0; i<A.length();i++){
            
            if(A_copy.equals(B)) {there=true; break;}
            
            char last = A_copy.charAt(A.length()-1);
            String front = A_copy.substring(0, A.length()-1);

            A_copy = last + front;
            toRightCnt++;
        }
        
        return there? toRightCnt : -1;
    }
}

