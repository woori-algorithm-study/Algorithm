class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int toRight = 0;
        int toLeft =0;
        boolean there = false;
        String A_copy = A;
	    
        for(int i=0; i<A.length();i++){
            if(A_copy.equals(B)) {there=true; break;}
            char last = A_copy.charAt(A.length()-1);
            String front = A_copy.substring(0, A.length()-2);//Error!
            A_copy = last + front;
            System.out.println(A_copy);
            toRight++;
        }
        
        return there? toRight: -1;
    }
}

/*
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 3
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:48)
	at java.base/java.lang.String.charAt(String.java:711)
	at Solution.solution(Unknown Source)
	at SolutionTest.lambda$main$0(Unknown Source)
	at SolutionTest$SolutionRunner.run(Unknown Source)
	at SolutionTest.main(Unknown Source)

 
 오류 원인 :  A_copy.substring(0, A.length()-2);
String	substring(int beginIndex) : Returns a string that is a substring of this string.
String	substring(int beginIndex, int endIndex) : Returns a string that is a substring of this string.

The endIndex includes itself in the returned interval.
*/
