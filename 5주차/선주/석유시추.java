import java.util.Stack;
/*어려웠던 점 : 방문 표시 중복 처리, 배열 접근 시 arr[y][x]; 로 접근해야 했던 것*/
class Solution {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    public int solution(int[][] land) {
        int max_oil = 0;
        int n = land.length;//땅의 세로길이:5
        int m = land[0].length;//땅의 가로길이:8

        for(int i = 0; i<m; i++){//각 세로줄을 실제로 시추해보기
            boolean [][] visited = new boolean[n][m];//방문을 기록해서 중복으로 세어지지 않게 됨.
            int oil = 0;//시추한번에 얻는 석유
            Stack<Integer> goTo = new Stack(); //(안에 두 칸짜리 List<Integer> 넣으려다가 그냥 두번씩 넣고 빼기로함)
            
            for(int j = -1; j<n-1; j++){//계속 아래로 가다가
                if(!visited[j+1][i] && land[j+1][i] == 1){//다음에 석유방을 만나면
                    visited[j+1][i] = true;
                    goTo.push(i);
                    goTo.push(j+1); //스택의 첫 번째 원소 [i,j]  
                }
            }
            while(!goTo.empty()){
                //중요:: pop 순서 꼭 지켜야 함 (넣은순서인 x, y 거꾸로)
                int y = goTo.pop();
                int x = goTo.pop();
                //visited[y][x] = true; <::: pop에서만 visited 체크하면 중복 처리 안됨
                oil++;//이번 시추의 석유+1
                //System.out.println("visited: x:"+x+" y:"+ y + " oil: "+ oil);
                //방문 하지 않은 사방의 위치로 갔을 때 석유를 만난다면 갈 곳으로 스택에 추가
                for(int a = 0; a<4; a++){//상,하,좌,우
                    int ty=y+dy[a];
                    int tx=x+dx[a];
                    if(tx>-1&& ty>-1 && tx<m && ty<n && visited[ty][tx] == false &&land[ty][tx] == 1){
                        visited[ty][tx] = true;
                        //이미 스택에 들어가 pop 되지 않았을 때 중복을 처리해주기 위해서 스택에 넣을 때 방문처리를 해줌.
                        goTo.push(tx);
                        goTo.push(ty);
                    }
                }
            }//스택while 한 번으로 for문을 끝내지 않는 경우 : 시추해서 두개 이상의 석유 방이 나올때 
            if (oil > max_oil){max_oil = oil;}

        }
        return max_oil;
    }
}
