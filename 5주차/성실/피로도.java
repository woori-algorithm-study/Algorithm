class Solution {
    boolean[] visited;
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
    
        
        visited = new boolean[dungeons.length];
        adventure(k, dungeons, 0);   
        
        return answer;
    }
    
    void adventure (int k, int[][] dungeons, int count) {
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                adventure(k - dungeons[i][1], dungeons, count+1);
                visited[i] = false;
            } 
        }
        
        if (count > answer) {
            answer = count;
        }
        
    }
}
