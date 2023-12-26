class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean find = false;
        for(String word : words){
            if(word.equals(target))
                find = true;
        }
        if(find){
            boolean[] visited = new boolean[words.length];
            dfs(begin, target, words, visited, 0);
        }
        else
            answer = 0;
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, boolean[] visited, int cnt){
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }else{
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && differ(begin, words[i])){
                    visited[i] = true;
                    dfs(words[i], target, words, visited, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public boolean differ(String str1, String str2){
        int cnt = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i)!=str2.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        else
            return false;
    }
}
