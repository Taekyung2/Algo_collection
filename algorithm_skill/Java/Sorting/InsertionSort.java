public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};
        int i, j;

        // 0 ~ i - 1까지는 정렬이 되어있음
        // i번째 원소를 정렬되어 있는 영역 어딘가에 삽입한다
        for(i = 1; i < arr.length; i++) {
            int tmp = arr[i];

            for(j = i - 1; j >= 0; j--) {
                if(tmp > arr[j])
                    break;
                else
                    arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }

        for(int num : arr)
            System.out.print(num + " ");
    }


    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
