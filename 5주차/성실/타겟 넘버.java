class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        int sum = 0;
        int depth = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }

    void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(target == sum) {
                answer++;
            } return;
        } 
        
        else {
            dfs(numbers, target, depth+1, sum+numbers[depth]);
            dfs(numbers, target, depth+1, sum-numbers[depth]);   
        }
    }
}
