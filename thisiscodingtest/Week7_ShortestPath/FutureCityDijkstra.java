package thisiscodingtest.Week7_ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1 ~ K, K ~ X

public class FutureCityDijkstra {

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
    static int X;
    static int K;
    static List<List<Network>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    static final int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start - 1).add(new Network(end - 1, 1));
            graph.get(end - 1).add(new Network(start - 1, 1));
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int toCompany = dijkstra(0, K - 1);
        int toMeeting = dijkstra(K - 1, X - 1);

        if (toCompany == MAX || toMeeting == MAX) {
            System.out.println("-1");
        } else {
            System.out.println(toCompany + toMeeting);
        }
    }

    static int dijkstra(int startVertex, int targetVertex) {
        distance = new int[N];
        visited = new boolean[N];
        Arrays.fill(distance, MAX);

        PriorityQueue<Network> dijkstraQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight()));
        distance[startVertex] = 0;
        dijkstraQueue.offer(new Network(startVertex, 0));

        while (!dijkstraQueue.isEmpty()) {
            Network currentNode = dijkstraQueue.poll();
            int currentIdx = currentNode.getIdx();
            int currentWeight = currentNode.getWeight();

            if (currentIdx == targetVertex) {
                return currentWeight;
            }

            if (visited[currentIdx]) {
                continue; // 이미 check한 Node는 MST에서 제외
            }

            visited[currentIdx] = true;
            for (int i = 0; i < graph.get(currentIdx).size(); i++) {
                Network neighbor = graph.get(currentIdx).get(i);
                int neighborIdx = neighbor.getIdx();
                int neighborWeight = neighbor.getWeight(); // currentIdx -> neighborIdx [Weight]

                if (distance[neighborIdx] > distance[currentIdx] + neighborWeight) {
                    distance[neighborIdx] = distance[currentIdx] + neighborWeight;
                    dijkstraQueue.offer(new Network(neighborIdx, distance[neighborIdx]));
                }
            }
        }

        return MAX;
    }
}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
>> 3

4 2
1 3
2 4
3 4
>> -1
 */