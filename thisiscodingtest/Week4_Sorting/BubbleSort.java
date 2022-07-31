package thisiscodingtest.Week4_Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = RandomNumberList.basicList(50, 50);
        RandomNumberList.printList("초기 제공 리스트", list);
        bubbleSort(list);
        RandomNumberList.printList("BubbleSort 후 정렬된 리스트", list);
    }
    
    static void bubbleSort(int[] list){
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if(list[i] > list[j]){
                    swap(list, i, j);
                }
            }
        }
    }

    static void swap(int[] list, int a, int b){
        int tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
}
