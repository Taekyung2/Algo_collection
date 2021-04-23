public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};

        // 인접한 원소 끼리 비교해서 큰 값을 뒤로 밀어낸다
        // 한 번 반복할 때마다 끝에 수가 하나씩 확정됨
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
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
