package thisiscodingtest.Week7_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek {

    static class Network {
        private int idx;
        private int weight;

        public Network(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        public int getIdx() {
            return idx;
        }

        public int getWeight() {
            return weight;
        }
    }

    static StringTokenizer st;
    static int N;
    static int M;
    static final int MAX = 987654321;
    static List<List<Network>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N];
        visited = new boolean[N];
        Arrays.fill(distance, MAX);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph.get(first - 1).add(new Network(second - 1, 1));
            graph.get(second - 1).add(new Network(first - 1, 1));
        }

        dijkstra(0);
        getResult();
    }

    static void dijkstra(int startVertex) {
        PriorityQueue<Network> dijkstraQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));
        distance[startVertex] = 0;
        dijkstraQueue.offer(new Network(startVertex, 0));

        while (!dijkstraQueue.isEmpty()) {
            Network currentNode = dijkstraQueue.poll();
            int currentIdx = currentNode.getIdx();

            if (visited[currentIdx]) {
                continue;
            }

            visited[currentIdx] = true;

            for (int i = 0; i < graph.get(currentIdx).size(); i++) {
                Network neighbor = graph.get(currentIdx).get(i);
                int neighborIdx = neighbor.getIdx();
                int neighborWeight = neighbor.getWeight();

                if (distance[neighborIdx] > distance[currentIdx] + neighborWeight) {
                    distance[neighborIdx] = distance[currentIdx] + neighborWeight;
                    dijkstraQueue.offer(new Network(neighborIdx, distance[neighborIdx]));
                }
            }
        }
    }

    static void getResult() {
        int hideValue = Integer.MIN_VALUE;

        for (int d : distance) {
            if (d > hideValue) {
                hideValue = d;
            }
        }

        int count = 0; // 같은 거리의 헛간 개수
        int hideIdx = Integer.MAX_VALUE; // 숨어야 하는 헛간의 idx (최솟값)
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == hideValue) {
                count++;
                hideIdx = Math.min(hideIdx, i);
            }
        }

        System.out.println((hideIdx + 1) + " " + distance[hideIdx] + " " + count);
    }
}

/*
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
>> 4 2 3
 */