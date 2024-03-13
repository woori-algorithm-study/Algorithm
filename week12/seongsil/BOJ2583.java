import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int result = 0; // 영역 개수
	static int area; // 영역 넓이
	static List<Integer> areaList = new ArrayList<>(); // 각 영역 넓이
	
    static int M; // 세로, y축, i
    static int N; // 가로, x축, j
    static int K; // 사각형 개수
    static int[][] paper; // 전체 종이
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();;
        N = sc.nextInt();
        K = sc.nextInt();
        paper = new int[M][N];
        for(int input=0; input<K; input++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int i = y1; i < y2; i++) {
            	for(int j = x1; j < x2; j++) {
                    paper[i][j] = 1;
                }
            }
        }

//        for (int i = 0; i < M; i++) {
//            for(int j = 0; j < N; j++){
//                System.out.print(paper[i][j]);
//            }
//            System.out.println();
//        }
        
        for (int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++){
                if(paper[i][j] == 0) {     	
                	area = 0;
                	dfs(i, j);
                	result++;
                	areaList.add(area);
                }
            }
        }
        
        Collections.sort(areaList);
        
        System.out.println(result);
        for(int i=0; i<areaList.size(); i++) {
        	System.out.print(areaList.get(i) + " ");
        }

    }
    
    static void dfs(int x, int y) {
    	area++;
    	paper[x][y] = 1;

    	for(int i=0; i<4; i++) {
    		int nextX = x + dx[i];
    		int nextY = y + dy[i];
    		
    		if(nextX >=0 && nextX < M && nextY >=0 && nextY < N) {
    			if(paper[nextX][nextY] == 0) {

    				dfs(nextX, nextY);
                }
    		}
   
    	}
    }
}
