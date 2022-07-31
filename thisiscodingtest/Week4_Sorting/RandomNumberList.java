package thisiscodingtest.Week4_Sorting;

// 정렬에 필요한 랜덤 리스트 제공 클래스
public class RandomNumberList {

    static int K; // 원소 랜덤 최댓값

    public static int[] basicList(int N, int K){
        int[] list = new int[N];

        for(int i=0; i<N; i++){
            list[i] = (int)(Math.random()*K + 1);
        }

        return list;
    }

    public static void printList(String s, int[] list){
        System.out.println("## " + s + " ##");
        for(int i=0; i<list.length; i++){
            if(i % 10 == 0 && i != 0){
                System.out.println();
            }
            System.out.print(list[i] + "\t");
        }
        System.out.println("\n");
    }
}
