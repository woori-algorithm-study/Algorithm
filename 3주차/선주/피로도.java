class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;//유저가 탐험할수 있는 최대 던전 수
        //boolean[] visited = new boolean[dungeons.length]; //배열의 각 인덱스별 방분 여부
        boolean[] visited = {false, false, false};
        int chury = 0; //이번 순서로 돌았을 때 돌 수 있는 던전수

            //permutations 구현방법?: abc bac acb
            //던전 a, b, c가 있을 때
            // 던전 순서를 구하는 방법 : [][][] 3개의 칸에 들어갈 a,b,c 를 정하는 것
            // 1. a가 1번째 / b가 2번째 or c가 2번째 /... 나머지 하나
            // 2. b가 1번째 / a가 2번째 or c가 2번째 /...
            // 3. c가 1번째 / b가 2번째 or a가 2번째 /...
            //경우의 수가 갈라지는 모습이 dfs,bfs 노드와 비슷한 모양
            
        for(int i = 0; i<dungeons.length; i++){
            chury = dfs(i, k, visited, dungeons);
            if(chury > answer){answer = chury;}//최대 던전수 업데이트
        }
        
        return answer;
    }
    
    public int dfs(int idx, int stamina, boolean[] visited , int[][] dungeons){
        visited[idx] = true;
        int cleared = 0;
       

        for(int i =0; i< dungeons.length; i++){
            int[] dungeon = dungeons[i];
            cleared++;
            if(stamina < dungeon[0]) continue; //이번 던전은 포기
            if(!visited[i]){ dfs(i, stamina-dungeon[1], visited, dungeons);}
        }
        return cleared;
    }
}
