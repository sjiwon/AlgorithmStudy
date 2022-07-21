package thisiscodingtest.Week3_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FreezeDrinks {

    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int count = 0;

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

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static boolean isRange(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Point poll = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = poll.getX() + dx[i];
                int nextY = poll.getY() + dy[i];

                if(isRange(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 0){
                    visited[nextX][nextY] = true;
                    queue.offer(new Point(nextX, nextY));
                }
            }
        }
    }
}

/*
4 5
00110
00011
11111
00000

15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
 */