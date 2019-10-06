package Array;

/**
 * Created by kaiscript on 2019/10/6.
 */
public class SearchElementSortedAndRotatedArray {

    public static void main(String[] args) {
        int arr[]={16,19,21,25,3,5,8,10};
        System.out.println("Index of element 5 : " + findElement(0, arr.length - 1, 5, arr));
    }

    public static int findElement(int low, int high, int number, int[] array) {

        int mid;
        while (low <= high) {
            mid = low + (high - low)/ 2 ;
            if (number == array[mid]) {
                return mid;
            }
            if (array[mid] <= array[high]) {
                if (number > array[mid] && number <= array[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            else {
                if (number < array[mid] && number >= array[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
