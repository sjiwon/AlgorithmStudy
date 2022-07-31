package thisiscodingtest.Week4_Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = RandomNumberList.basicList(50, 50);
        RandomNumberList.printList("초기 제공 리스트", list);
        insertionSort(list);
        RandomNumberList.printList("InsertionSort 후 정렬된 리스트", list);
    }

    static void insertionSort(int[] list){
        for (int i = 1; i < list.length; i++) {
            int exchangeValue = list[i]; // exchangeValue가 들어갈 위치 찾아주기
            int selectIndex = i - 1; // 최종적으로 exchangeValue가 들어갈 위치 = selectIndex + 1

            while(selectIndex >= 0 && list[selectIndex] > exchangeValue){
                list[selectIndex + 1] = list[selectIndex]; // 한칸씩 뒤로 밀기
                selectIndex--;
            }

            list[selectIndex + 1] = exchangeValue;
        }
    }
}
