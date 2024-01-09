class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int num = 0;
        
        for (int i = 0; i < section.length; i++) {
            if (section[i] < num) {
                continue;
            } else {
                num = section[i]+m;
                System.out.println(num);
                answer++;
            }
        }
        
        return answer;
    }
}