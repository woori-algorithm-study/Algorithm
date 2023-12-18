class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int toRight = 0;
        int toLeft =0;
        boolean there = false;
        String A_copy = A;
        //if len>1 for 스킵하면 A가 B와 같은지 판단 못함
        for(int i=0; i<A.length();i++){
            if(A_copy.equals(B)) {there=true; break;}
            char last = A_copy.charAt(A.length()-1);
            String front = A_copy.substring(0, A.length()-2);
            A_copy = last + front;
            System.out.println(A_copy);
            toRight++;
        }

        for(int j=A.length()-1; j>=0; j--){
            if(A_copy.equals(B)) {there=true; break;}
            char first = A_copy.charAt(0);
            String back = A_copy.substring(1, A.length()-1);
            A_copy = back + first;
            toLeft++;
        }
        
        return there? ( (toRight> toLeft)? toLeft : toRight ): -1;
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
*/
