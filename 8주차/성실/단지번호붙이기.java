public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // x좌표 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // y좌표 상하좌우
    static int complex = 0; // 단지 수
    static int home = 0; // 집 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String num = sc.next();
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(""+num.charAt(j));
            }
        }

        List<Integer> homeList = new ArrayList<>(); // 집 수 모아줄 리스트
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) { // 값이 1이거나 아직 방문x
                    dfs(i, j); // 상하좌우 확인
                    complex++; // 한번 돌고 오면 단지 수 올려줌
                    homeList.add(home);
                    home = 0;
                }
            }
        }

        Collections.sort(homeList);

        System.out.println(complex);
        for(int i = 0; i < homeList.size(); i++) {
            System.out.println(homeList.get(i));
        }

    }


    static void dfs(int x, int y) {
        visited[x][y] = true; // 방문 표시
        home++; // 집 수 더해줌

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
