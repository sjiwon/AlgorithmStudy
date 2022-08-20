package thisiscodingtest.Week7_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MarsExploration {

    static class Network {
        private int x;
        private int y;
        private int weight;

        public Network(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWeight() {
            return weight;
        }
    }

    static StringTokenizer st;
    static int N;
    static final int MAX = 987654321;
    static int[][] matrix;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];
            distance = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], MAX);
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            sb.append(distance[N - 1][N - 1]).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Network> dijkstraQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));
        distance[0][0] = matrix[0][0];
        dijkstraQueue.offer(new Network(0, 0, distance[0][0]));

        while (!dijkstraQueue.isEmpty()) {
            Network currentPoint = dijkstraQueue.poll();
            int currentX = currentPoint.getX();
            int currentY = currentPoint.getY();
            int currentWeight = currentPoint.getWeight();

            if (visited[currentX][currentY]) { // check한 Point는 고려 X
                continue;
            }

            visited[currentX][currentY] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (isRange(nextX, nextY)) {
                    if (distance[nextX][nextY] > currentWeight + matrix[nextX][nextY]) {
                        distance[nextX][nextY] = currentWeight + matrix[nextX][nextY];
                        dijkstraQueue.offer(new Network(nextX, nextY, distance[nextX][nextY]));
                    }
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}

/*
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
>> 20 19 36
 */