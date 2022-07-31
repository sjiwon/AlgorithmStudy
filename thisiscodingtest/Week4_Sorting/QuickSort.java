package thisiscodingtest.Week4_Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = RandomNumberList.basicList(50, 50);
        RandomNumberList.printList("초기 제공 리스트", list);
        quickSort(list, 0, list.length - 1);
        RandomNumberList.printList("QuickSort 후 정렬된 리스트", list);
    }

    static void quickSort(int[] list, int left, int right){
        if(left < right){
            int pivot = Partition(list, left, right);
            quickSort(list, left, pivot - 1);
            quickSort(list, pivot + 1, right);
        }
    }

    static int Partition(int[] list, int left, int right){
        int mid = (left + right) / 2;
        int pivot = list[mid];
        int pivotIndex = left - 1; // 최종적인 pivot의 위치
        
        swap(list, mid, right); // pivot 맨 오른쪽으로 보내기

        for (int i = left; i < right; i++) {
            if(list[i] < pivot){
                swap(list, ++pivotIndex, i);
            }
        }

        swap(list, pivotIndex + 1, right);
        return pivotIndex + 1;
    }

    static void swap(int[] list, int a, int b){
        int tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
}
