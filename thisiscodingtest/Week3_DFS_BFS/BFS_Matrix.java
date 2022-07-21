package thisiscodingtest.Week3_DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Matrix {

    static boolean [] visited;

    public static void main(String[] args) {
        int[][] bfsMatrix = DFS_BFS_Init.getBfsMatrix();
        visited = new boolean[bfsMatrix.length];

        System.out.println("\n## 큐를 이용한 BFS (인접 행렬) ##");
        for(int i=0; i<bfsMatrix.length; i++){
            bfsMatrix(bfsMatrix, i, bfsMatrix.length);
            initVisited();
        }
    }

    static void bfsMatrix(int[][] bfsMatrix, int startVertex, int N){
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.offer(startVertex);

        System.out.print("시작 노드(" + (startVertex + 1) + ") :: ");

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.print((poll + 1) + " -> ");
            for(int w = 0; w < N; w++){
                if(!visited[w] && bfsMatrix[poll][w] == 1 && !queue.contains(w)){
                    visited[w] = true;
                    queue.offer(w);
                }
            }
        }

        System.out.println();
    }

    static void initVisited(){
        Arrays.fill(visited, false);
    }
}
