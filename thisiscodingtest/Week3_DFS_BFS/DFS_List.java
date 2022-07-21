package thisiscodingtest.Week3_DFS_BFS;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFS_List {

    static boolean [] visited;

    public static void main(String[] args) {
        List<Integer>[] dfsList = DFS_BFS_Init.getDfsList();
        visited = new boolean[dfsList.length];

        System.out.println("## 스택을 이용한 DFS (인접 리스트) ##");
        for(int i=0; i<dfsList.length; i++){
            dfsListWithStack(dfsList, i, dfsList.length);
            initVisited();
        }

        System.out.println("\n## 재귀를 이용한 DFS (인접 리스트) ##");
        for(int i=0; i<dfsList.length; i++){
            System.out.print("시작 노드(" + (i + 1) + ") :: ");
            dfsListWithRecursion(dfsList, i, dfsList.length);
            System.out.println();
            initVisited();
        }
    }

    static void dfsListWithStack(List<Integer>[] dfsList, int startVertex, int N){
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        visited[startVertex] = true;

        System.out.print("시작 노드(" + (startVertex + 1) + ") :: ");

        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            System.out.print((pop + 1) + " -> ");

            for(int i = 0; i<dfsList[pop].size(); i++){
                Integer neighbor = dfsList[pop].get(i);
                if(!visited[neighbor] && !stack.contains(neighbor)){
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        System.out.println();
    }

    static void dfsListWithRecursion(List<Integer>[] dfsList, int startVertex, int N){
        visited[startVertex] = true;
        System.out.print((startVertex + 1) + " -> ");

        for(int i=0; i<dfsList[startVertex].size(); i++){
            Integer neighbor = dfsList[startVertex].get(i);
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfsListWithRecursion(dfsList, neighbor, N);
            }
        }
    }

    static void initVisited(){
        Arrays.fill(visited, false);
    }
}
