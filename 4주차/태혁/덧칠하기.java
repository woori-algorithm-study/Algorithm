class Solution {
    private static int min = Integer.MAX_VALUE;
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++)
            visited[i] = true;
        
        for(int i = 0 ; i < section.length; i++)
            visited[section[i]-1] = false;
        
        dfs(visited, m, 0, section[0]-1);
        
        return min;
    }
    
    public void dfs(boolean[] visited, int m, int cnt, int index){
        if(checkAllVisited(visited)){
            min = Math.min(min, cnt);
        }
        else{
            for(int i = index; i < visited.length; i++){
                if(!visited[i]){
                    boolean paint = false;
                    for(int j = 0; j < m; j++){
                        if(i+j < visited.length && !visited[i+j]){
                            visited[i+j] = true;
                            paint = true;
                        }
                    }
                    if(paint)
                        cnt++;
                    dfs(visited, m, cnt, index++);
                    for(int j = 0; j < m; j++){
                        if(i+j < visited.length && !visited[i+j]){
                            visited[i+j] = false;
                        }
                    }
                }
            }
        }
    }
    public boolean checkAllVisited(boolean[] visited){
        for(boolean b : visited)
            if(!b)
                return false;
        return true;
    }
}
