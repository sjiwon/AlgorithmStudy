package thisiscodingtest.Week7_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MessageTransfer {

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
    static List<List<Network>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    static final int MAX = 987654321;
    static int N;
    static int M;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        distance = new int[N];
        visited = new boolean[N];
        Arrays.fill(distance, MAX);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start - 1).add(new Network(end - 1, weight));
        }

        dijkstra(C - 1);
        getResult();
    }

    static void dijkstra(int startCity) {
        PriorityQueue<Network> dijkstraQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));
        distance[startCity] = 0;
        dijkstraQueue.offer(new Network(startCity, 0));

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
        int count = 0;
        int time = 0;

        for (int d : distance) {
            if (d != MAX) {
                count++;
                time = Math.max(time, d);
            }
        }
        count -= 1; // 도시 C 제거

        System.out.println(count + " " + time);
    }
}

/*
3 2 1
1 2 4
1 3 2
>> 2 4
 */