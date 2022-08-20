package thisiscodingtest.Week7_ShortestPath;

import java.util.*;

public class Dijkstra {

    static class Network{
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

        @Override
        public String toString() {
            return "Network{" +
                    "target=" + idx +
                    ", weight=" + weight +
                    '}';
        }
    }

    static final int MAX_DISTANCE = 987654321;
    static List<Network>[] basicDijkstraGraph;
    static int[] distance;
    static boolean[] visited;
    static int step;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 3; i++) {
            System.out.println("───────────────────────────────────────────────────────────────");
            basicDijkstraGraph = ShortestPathBasicGraph.getBasicDijkstraGraph(i);

            for (int k = 0; k < ShortestPathBasicGraph.getVertexNum(); k++) {
                step = 1;
                distance = new int[ShortestPathBasicGraph.getVertexNum()];
                visited = new boolean[ShortestPathBasicGraph.getVertexNum()];
                distanceInitialization();
                simulateDijkstraAlgorithm(basicDijkstraGraph, k);
            }
        }
    }

    static void simulateDijkstraAlgorithm(List<Network>[] basicDijkstraGraph, int startVertex) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("시작 정점 = " + startVertex + "\n");

        PriorityQueue<Network> dijkstraQueue = new PriorityQueue<>(Comparator.comparingInt(Network::getWeight));
        dijkstraQueue.offer(new Network(startVertex, 0));
        distance[startVertex] = 0;

        while (!dijkstraQueue.isEmpty()) {
            Network currentNode = dijkstraQueue.poll();
            int currentIdx = currentNode.getIdx();

            if (visited[currentIdx]) {
                continue;
            }

            visited[currentIdx] = true;

            for (int i = 0; i < basicDijkstraGraph[currentIdx].size(); i++) {
                Network neighbor = basicDijkstraGraph[currentIdx].get(i);

                if (distance[neighbor.getIdx()] > distance[currentIdx] + neighbor.getWeight()) {
                    distance[neighbor.getIdx()] = distance[currentIdx] + neighbor.getWeight();
                }

                dijkstraQueue.offer(new Network(neighbor.getIdx(), distance[neighbor.getIdx()]));
            }
            processInfo(currentIdx);
        }
    }

    static void distanceInitialization() {
        // Distance Initialization
        Arrays.fill(distance, MAX_DISTANCE);
    }

    static void processInfo(int idx) {
        System.out.println("Step " + step++ + ". node[" + idx + "] 선택");

        System.out.print(">> Distance\t= [");
        for (int i = 0; i < distance.length - 1; i++) {
            if (distance[i] == MAX_DISTANCE) {
                System.out.print("INF ");
            } else {
                System.out.print(distance[i] + " ");
            }
        }
        if (distance[distance.length - 1] == MAX_DISTANCE) {
            System.out.println("INF]");
        } else {
            System.out.println(distance[distance.length - 1] + "]");
        }

        System.out.print(">> Visited\t= [");
        for (int i = 0; i < visited.length - 1; i++) {
            if (visited[i]) {
                System.out.print("T ");
            } else {
                System.out.print("F ");
            }
        }
        if (visited[visited.length - 1]) {
            System.out.println("T]\n");
        } else {
            System.out.println("F]\n");
        }
    }
}
