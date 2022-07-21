package thisiscodingtest.Week3_DFS_BFS;

import java.util.ArrayList;
import java.util.List;

// DFS(행렬/리스트), BFS(행렬/리스트)를 구현하기 위한 "샘플 행렬/리스트 제공 클래스"

public class DFS_BFS_Init {
    static int [][] matrix = new int[][]{
            {0, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0}
    };

    public static int[][] getDfsMatrix(){
        return matrix;
    }

    public static List<Integer>[] getDfsList(){
        return generateList();
    }

    public static int[][] getBfsMatrix(){
        return matrix;
    }

    public static List<Integer>[] getBfsList(){
        return generateList();
    }

    static List<Integer>[] generateList(){
        List<Integer>[] list = new List[8];
        for(int i=0; i<8; i++){
            list[i] = new ArrayList<>();
        }

        list[0].add(1); list[0].add(2); list[0].add(7);
        list[1].add(0); list[1].add(6);
        list[2].add(0); list[2].add(3); list[2].add(4);
        list[3].add(2); list[3].add(4);
        list[4].add(2); list[4].add(3);
        list[5].add(6);
        list[6].add(1); list[6].add(5); list[6].add(7);
        list[7].add(0); list[7].add(6);

        return list;
    }
}
