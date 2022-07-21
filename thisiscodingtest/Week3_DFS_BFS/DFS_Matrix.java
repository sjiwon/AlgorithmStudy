package thisiscodingtest.Week3_DFS_BFS;

import java.util.Arrays;
import java.util.Stack;

public class DFS_Matrix {

    static boolean [] visited;

    public static void main(String[] args) {
        int[][] dfsMatrix = DFS_BFS_Init.getDfsMatrix();
        visited = new boolean[dfsMatrix.length];

        System.out.println("## 스택을 이용한 DFS (인접 행렬) ##");
        for(int i=0; i<dfsMatrix.length; i++){
            dfsMatrixWithStack(dfsMatrix, i, dfsMatrix.length);
            initVisited();
        }


        System.out.println("\n## 재귀를 이용한 DFS (인접 행렬) ##");
        for(int i=0; i<dfsMatrix.length; i++){
            System.out.print("시작 노드(" + (i + 1) + ") :: ");
            dfsMatrixWithRecursion(dfsMatrix, i, dfsMatrix.length);
            System.out.println();
            initVisited();
        }
    }

    static void dfsMatrixWithStack(int[][] dfsMatrix, int startVertex, int N){
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited[startVertex] = true;

        System.out.print("시작 노드(" + (startVertex + 1) + ") :: ");

        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            System.out.print((pop + 1) + " -> ");

            for(int w=0; w<N; w++){
                if(!visited[w] && dfsMatrix[pop][w] == 1 && !stack.contains(w)){
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }

        System.out.println();
    }

    static void dfsMatrixWithRecursion(int[][] dfsMatrix, int startVertex, int N){
        visited[startVertex] = true;
        System.out.print((startVertex + 1) + " -> ");

        for(int w=0; w<N; w++){
            if(!visited[w] && dfsMatrix[startVertex][w] == 1){
                dfsMatrixWithRecursion(dfsMatrix, w, N);
            }
        }
    }

    static void initVisited(){
        Arrays.fill(visited, false);
    }
}
