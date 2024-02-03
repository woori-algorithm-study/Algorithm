import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static int N;
	static int M;
	static int[][] maze;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] str = sc.next().split("");
			for(int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		bfs();
		System.out.println(maze[N-1][M-1]);
		
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		visited[0][0] = true;
		q.add(new int[] {0, 0});
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >=0 && nx < N && ny >= 0 && ny < M) { // 범위 벗어나지 않는지 확인
					if(maze[nx][ny] == 1 && !visited[nx][ny]) { // 이동할 수 있는 칸인지, 방문하지 않은 곳인지 확인
						visited[nx][ny] = true;
						q.add(new int[] {nx, ny});
						maze[nx][ny] = maze[x][y] + 1;
					}
				}
				
			}
			
		}
		
		
	}

}
