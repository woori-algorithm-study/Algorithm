import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R;
	static int C;
	static String[][] maze;
	static Deque<int[]> hoon;
	static Deque<int[]> fire;
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		maze = new String[R][C];
		hoon = new ArrayDeque<>();
		fire = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				maze[i][j] = str[j];
				if (maze[i][j].equals("J")) hoon.addLast(new int[] {i, j});
				else if (maze[i][j].equals("F")) fire.addLast(new int[] {i, j});
			}
		}
				
		bfs();
		
	}
	
	static void bfs() {
				
		while (!hoon.isEmpty()) {
			
			int fireSize = fire.size();
			for (int i = 0; i < fireSize; i++) {
				
				int[] xy = fire.pollFirst();
				int x = xy[0];
				int y = xy[1];
				
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (!maze[nx][ny].equals("#") && !maze[nx][ny].equals("F")) {
							fire.addLast(new int[] {nx, ny});
							maze[nx][ny] = "F";
						}
					}
				}
			}
			
			int hoonSize = hoon.size();
			for (int i = 0; i < hoonSize; i++) {
				
				int[] xy = hoon.pollFirst();
				int x = xy[0];
				int y = xy[1];
				
				if (x == 0 || x == R-1 || y == 0 || y == C-1) {
					System.out.println(count + 1);
					return;
				}
				
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (maze[nx][ny].equals(".")) {
							hoon.addLast(new int[] {nx, ny});
							maze[nx][ny] = "J";
						}
					}
				}
			}
					
			count++;
			
		}
		
		System.out.println("IMPOSSIBLE");		
	}

}
