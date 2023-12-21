class Solution {
    public int solution(String A, String B) {
        int toRightCnt = 0;
        boolean there = false;
        
        for(int i=0; i<A.length();i++){
            
            if(A.equals(B)) {there=true; break;}
            
            char last = A.charAt(A.length()-1);
            String front = A.substring(0, A.length()-1);

            A = last + front;
            toRightCnt++;
        }
        
        return there? toRightCnt : -1;
    }
}

/*
String	substring(int beginIndex) : Returns a string that is a substring of this string.
String	substring(int beginIndex, int endIndex) : Returns a string that is a substring of this string.

The endIndex includes itself in the returned interval.
*/
