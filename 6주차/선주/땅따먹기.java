import java.lang.Math;
class Solution {
    int before;
    int solution(int[][] land) {
        int answer = 0;
        //이 땅따먹기 위치에서 이전 모든행에서 받을 수 있는 최대 점수
        //(자기자신 + 이전 행 최대값 + 이전 행들의 누적 최대점수)
        int a=0; //max() 가독성을 위한 변수
        int b=0;
        int c=0;
        int d=0;

        for(int y=1; y<land.length; y++){ //행을 탐색한다.
            int b_row = y-1; //before_row
            
            a = land[b_row][0];
            b = land[b_row][1];
            c = land[b_row][2];
            d = land[b_row][3];
            
            land[y][0] += Math.max(Math.max(b, c), d);//   1 2 3
            land[y][1] += Math.max(Math.max(a, c), d);// 0   2 3 
            land[y][2] += Math.max(Math.max(a, b), d);// 0 1   3
            land[y][3] += Math.max(Math.max(a, b), c);// 0 1 2
            /*for(int i=0; i<4; i++){
                System.out.print("|"+land[y][i]+"|");
            }
            System.out.println();*/
        }
    
        a = land[land.length-1][0];
        b = land[land.length-1][1];
        c = land[land.length-1][2];
        d = land[land.length-1][3];
        //point의 마지막 행 중 최대값이 이 땅따먹기에서 받을 수 있는 최대 점수.

        return Math.max(Math.max(a,b), Math.max(c,d));
    }
}
