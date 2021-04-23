public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};

        for(int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
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
