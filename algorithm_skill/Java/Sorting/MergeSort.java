public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1};

        myMergeSort(arr, 0, arr.length - 1);

        for(int num : arr)
            System.out.print(num + " ");
    }


    public static void myMergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;

            myMergeSort(arr, left, mid);
            myMergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }


    public static void merge(int[] arr, int left, int mid, int right) {
        int idx = left;
        int i = left, j = mid + 1;
        int[] tmp = new int[arr.length];

        while(i <= mid || j <= right) {
            if(j > right || (i <= mid && arr[i] < arr[j])) {
                tmp[idx++] = arr[i++];
            } else {
                tmp[idx++] = arr[j++];
            }
        }

        for(int s = left; s <= right; s++)
            arr[s] = tmp[s];
    }



    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
