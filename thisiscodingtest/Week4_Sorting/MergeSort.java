package thisiscodingtest.Week4_Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] list = RandomNumberList.basicList(50, 50);
        RandomNumberList.printList("초기 제공 리스트", list);
        mergeSort(list, 0, list.length - 1);
        RandomNumberList.printList("MergeSort 후 정렬된 리스트", list);
    }

    static void mergeSort(int[] list, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    static void merge(int[] list, int left, int mid, int right){
        int[] buffer = new int[list.length];

        int leftIndex = left;
        int rightIndex = mid + 1;
        int bufferIndex = left;

        while(leftIndex <= mid && rightIndex <= right){
            if(list[leftIndex] < list[rightIndex]){
                buffer[bufferIndex++] = list[leftIndex++];
            } else {
                buffer[bufferIndex++] = list[rightIndex++];
            }
        }

        if(leftIndex > mid){
            while(rightIndex <= right){
                buffer[bufferIndex++] = list[rightIndex++];
            }
        } else {
            while(leftIndex <= mid){
                buffer[bufferIndex++] = list[leftIndex++];
            }
        }

        for (int i = left; i <= right; i++) {
            list[i] = buffer[i];
        }
    }
}
