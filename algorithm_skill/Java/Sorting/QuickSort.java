public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};

        myQuickSort(arr, 0, arr.length - 1);

        for(int num : arr)
            System.out.print(num + " ");
    }


    public static void myQuickSort(int[] arr, int left, int right) {
        if(left >= right)
            return;

        int pivot = partition(arr, left, right);

        myQuickSort(arr, left, pivot - 1);
        myQuickSort(arr, pivot + 1, right);
    }


    public static int partition(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        swap(arr, left, mid);

        int pivot = arr[left];
        int i = left, j = right;

        while(i < j) {
            while(pivot <= arr[j])
                j--;
            while(i < j && pivot >= arr[i])
                i++;
            swap(arr, i, j);
        }

        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }


    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}