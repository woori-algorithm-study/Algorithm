import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int M;
	static int N;
	static int K;
	static int[][] land;
	static int result;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int index = 0;
		while(index < T) {
			result = 0;
			String[] str = br.readLine().split(" ");
			M = Integer.parseInt(str[0]);
			N = Integer.parseInt(str[1]);
			K = Integer.parseInt(str[2]);
			land = new int[N][M];
			
			for(int i = 0; i < K; i++) {
				String[] str2 = br.readLine().split(" ");
				int y = Integer.parseInt(str2[0]);
				int x = Integer.parseInt(str2[1]);
				land[x][y] = 1;
			}
			
			//System.out.println(Arrays.deepToString(land));
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(land[i][j] == 1) {
						check(i, j);
						result++;
					}
				}
			}
			
			index++;
			System.out.println(result);
			
		}		
	}
	
	static void check(int x, int y) {
		land[x][y] = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if(land[nx][ny] == 1) check(nx, ny);
			}
		}
	}
}
