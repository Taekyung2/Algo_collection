public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 4, 5, 6, 7};
        System.out.println(binarySearch(arr, 4));
        System.out.println(upperBound(arr, 4));
        System.out.println(lowerBound(arr, 4));
    }


    public static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }


    public static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if(arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }


    public static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if(arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }
}