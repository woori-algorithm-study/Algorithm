package week13.sungmin;

import java.io.*;
import java.util.*;
public class BOJ4179 {
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<Node> q1; //지훈
    static Deque<Node> q2; //불
    static int R, C, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); //행의 개수
        C = Integer.parseInt(st.nextToken()); //열의 개수
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
        map = new char[R][C];

        // 지훈이 먼저 이동 -> 불 이동, 한 군데서 만나면 타죽음
        //불은 여러개 지훈이는 한명
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                if (c == 'J') {
                    q1.offerLast(new Node(i, j, 0));
                } else if (c == 'F') {
                    q2.offerLast(new Node(i, j, 0));
                }
                map[i][j] = c;
            }
        }

        if (bfs()) {
            System.out.println(answer);
        } else {
            System.out.println("IMPOSSIBLE");          
        }
        
    }

    static boolean bfs() {
        while (!q1.isEmpty()) {
            for (int i = 0; i < q2.size(); i++) {
                Node node = q2.pollFirst();
                int x = node.x;
                int y = node.y;
                int time = node.time;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] != '#' && map[nx][ny] != 'F') {
                            map[nx][ny] = 'F';
                            q2.offerLast(new Node(nx, ny, time+1));
                        }
                    }
                }
            }

            for (int i = 0; i < q1.size(); i++) {
                Node node = q1.pollFirst();
                int x = node.x;
                int y = node.y;
                int time = node.time;
    
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
    
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                        answer = time+1;
                        return true;
                    }
    
    
                    if(map[nx][ny] != '#' && map[nx][ny] !='F' && map[nx][ny] != 'J') {
                        map[nx][ny] = 'J';
                        q1.offerLast(new Node(nx, ny, time+1));
                    }
                }

            }
        }
        return false;
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node (int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
