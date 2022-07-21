package thisiscodingtest.Week3_DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_List {

    static boolean [] visited;

    public static void main(String[] args) {
        List<Integer>[] bfsList = DFS_BFS_Init.getBfsList();
        visited = new boolean[bfsList.length];

        System.out.println("\n## 큐를 이용한 BFS (인접 리스트) ##");
        for(int i=0; i<bfsList.length; i++){
            bfsList(bfsList, i, bfsList.length);
            initVisited();
        }
    }

    static void bfsList(List<Integer>[] bfsList, int startVertex, int N){
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.offer(startVertex);

        System.out.print("시작 노드(" + (startVertex + 1) + ") :: ");

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.print((poll + 1) + " -> ");

            for(int i=0; i<bfsList[poll].size(); i++){
                Integer neighbor = bfsList[poll].get(i);
                if(!visited[neighbor] && !queue.contains(neighbor)){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }

    static void initVisited(){
        Arrays.fill(visited, false);
    }
}
