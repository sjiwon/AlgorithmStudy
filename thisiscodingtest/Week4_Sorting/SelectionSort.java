package thisiscodingtest.Week4_Sorting;

import java.time.LocalDateTime;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = RandomNumberList.basicList(50, 50);
        RandomNumberList.printList("초기 제공 리스트", list);

        int minute = LocalDateTime.now().getMinute();

        if(minute % 2 == 0){
            selectionSortV1(list);
            RandomNumberList.printList("SelectionSortV1 후 정렬된 리스트", list);
        } else {
            selectionSortV2(list);
            RandomNumberList.printList("SelectionSortV2 후 정렬된 리스트", list);
        }
    }

    // Index(0) : 리스트 처음부터 순서대로 정렬
    static void selectionSortV1(int[] list){
        for (int i = 0; i < list.length; i++) {
            int minValueIndex = getMinValueIndex(list, i, list.length - 1);
            swap(list, i, minValueIndex);
        }
    }

    // Index(list.length-1) : 리스트 마지막부터 역순으로 정렬
    static void selectionSortV2(int[] list){
        for (int i = list.length - 1; i >= 0; i--) {
            int maxValueIndex = getMaxValueIndex(list, i, 0);
            swap(list, i, maxValueIndex);
        }
    }

    static int getMinValueIndex(int[] list, int startIndex, int endIndex) {
        int minIndex = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if(list[minIndex] > list[i]){
                minIndex = i;
            }
        }

        return minIndex;
    }

    static int getMaxValueIndex(int[] list, int startIndex, int endIndex){
        int maxIndex = endIndex;

        for (int i = endIndex + 1; i <= startIndex; i++) {
            if(list[maxIndex] < list[i]){
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    static void swap(int[] list, int a, int b){
        int tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
}
