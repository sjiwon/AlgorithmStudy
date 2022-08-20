package thisiscodingtest.Week7_ShortestPath;

import java.io.File;
import java.util.*;

public class ShortestPathBasicGraph {

    private static List<Dijkstra.Network>[] dijkstraGraph1;
    private static List<Dijkstra.Network>[] dijkstraGraph2;
    private static List<Dijkstra.Network>[] dijkstraGraph3;
    private static int[][] floydWarshallMatrix1;
    private static int[][] floydWarshallMatrix2;
    private static int[][] floydWarshallMatrix3;
    private static int vertexNum;

    static final String fileName1 = "C:\\tools\\Graph1.txt";
    static final String fileName2 = "C:\\tools\\Graph2.txt";
    static final String fileName3 = "C:\\tools\\Graph3.txt";
    static Scanner sc;

    public static List<Dijkstra.Network>[] getBasicDijkstraGraph(int K) throws Exception {
        if (K == 0) {
            initDijkstraGraph1();
            return dijkstraGraph1;
        } else if (K == 1) {
            initDijkstraGraph2();
            return dijkstraGraph2;
        } else {
            initDijkstraGraph3();
            return dijkstraGraph3;
        }
    }

    public static int[][] getBasicFloydWarshallMatrix(int K) throws Exception {
        if (K == 0) {
            initFloydWarshallMatrix1();
            return floydWarshallMatrix1;
        } else if (K == 1) {
            initFloydWarshallMatrix2();
            return floydWarshallMatrix2;
        } else {
            initFloydWarshallMatrix3();
            return floydWarshallMatrix3;
        }
    }

    private static void initDijkstraGraph1() throws Exception {
        // Node [0 ~ 5] + 단방향/양방향 그래프
        StringBuilder sb = new StringBuilder();
        sc = new Scanner(new File(fileName1));

        vertexNum = 6;
        dijkstraGraph1 = new List[vertexNum];
        for (int i = 0; i < 6; i++) {
            dijkstraGraph1[i] = new ArrayList<>();
        }

        System.out.println("## Graph1 정보 [VertextCount = " + getVertexNum() +  "] ##");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line.strip());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sb.append(start).append("[Start] -> ").append(target).append("[End] :: Weight = ").append(weight).append("\n");

            dijkstraGraph1[start].add(new Dijkstra.Network(target, weight));
        }

        System.out.println(sb);
    }

    private static void initDijkstraGraph2() throws Exception {
        // Node [0 ~ 5] + 양방향 그래프
        StringBuilder sb = new StringBuilder();
        sc = new Scanner(new File(fileName2));

        vertexNum = 6;
        dijkstraGraph2 = new List[vertexNum];
        for (int i = 0; i < 6; i++) {
            dijkstraGraph2[i] = new ArrayList<>();
        }

        System.out.println("## Graph2 정보 [VertextCount = " + getVertexNum() +  "] ##");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line.strip());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sb.append(start).append("[Start] <-> ").append(target).append("[End] :: Weight = ").append(weight).append("\n");

            dijkstraGraph2[start].add(new Dijkstra.Network(target, weight));
            dijkstraGraph2[target].add(new Dijkstra.Network(start, weight));
        }

        System.out.println(sb);
    }

    private static void initDijkstraGraph3() throws Exception {
        // Node [0 ~ 6] + 양방향 그래프
        StringBuilder sb = new StringBuilder();
        sc = new Scanner(new File(fileName3));

        vertexNum = 7;
        dijkstraGraph3 = new List[vertexNum];
        for (int i = 0; i < 7; i++) {
            dijkstraGraph3[i] = new ArrayList<>();
        }

        System.out.println("## Graph3 정보 [VertextCount = " + getVertexNum() +  "] ##");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line.strip());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sb.append(start).append("[Start] <-> ").append(target).append("[End] :: Weight = ").append(weight).append("\n");

            dijkstraGraph3[start].add(new Dijkstra.Network(target, weight));
            dijkstraGraph3[target].add(new Dijkstra.Network(start, weight));
        }

        System.out.println(sb);
    }

    private static void initFloydWarshallMatrix1() throws Exception {
        // Node [0 ~ 5] + 단방향/양방향 그래프
        sc = new Scanner(new File(fileName1));

        vertexNum = 6;
        floydWarshallMatrix1 = new int[vertexNum][vertexNum];

        System.out.println("─────────────────────── Graph1 정보 [VertextCount = " + getVertexNum() +  "] ───────────────────────");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line.strip());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            floydWarshallMatrix1[start][target] = weight;
        }

        printFloydWarshallMatrix("FloydWarshall Algorithm 적용 전", floydWarshallMatrix1);
    }

    private static void initFloydWarshallMatrix2() throws Exception {
        // Node [0 ~ 5] + 양방향 그래프
        sc = new Scanner(new File(fileName2));

        vertexNum = 6;
        floydWarshallMatrix2 = new int[vertexNum][vertexNum];

        System.out.println("─────────────────────── Graph2 정보 [VertextCount = " + getVertexNum() +  "] ───────────────────────");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line.strip());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            floydWarshallMatrix2[start][target] = floydWarshallMatrix2[target][start] = weight;
        }

        printFloydWarshallMatrix("FloydWarshall Algorithm 적용 전", floydWarshallMatrix2);
    }

    private static void initFloydWarshallMatrix3() throws Exception {
        // Node [0 ~ 6] + 양방향 그래프
        sc = new Scanner(new File(fileName3));

        vertexNum = 7;
        floydWarshallMatrix3 = new int[vertexNum][vertexNum];

        System.out.println("─────────────────────── Graph3 정보 [VertextCount = " + getVertexNum() +  "] ───────────────────────");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line.strip());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            floydWarshallMatrix3[start][target] = floydWarshallMatrix3[target][start] = weight;
        }

        printFloydWarshallMatrix("FloydWarshall Algorithm 적용 전", floydWarshallMatrix3);
    }

    private static void printFloydWarshallMatrix(String title, int[][] M) {
        System.out.println("[" + title + "]");
        for (int[] ints : M) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getVertexNum() {
        return vertexNum;
    }
}
