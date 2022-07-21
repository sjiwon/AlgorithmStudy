package thisiscodingtest.Week3_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeEscape {

    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static int bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point poll = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = poll.getX() + dx[i];
                int nextY = poll.getY() + dy[i];

                if(isRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] != 0){
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[poll.getX()][poll.getY()] + 1;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }

        return map[N-1][M-1];
    }
}

/*
5 6
101010
111111
000001
111111
111111
 */
