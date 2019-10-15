package Algorithms.Array;

/**
 * If you note that array is sorted and rotated. You need to find minimum element in above array in o(log n) time complexity.
 * You can assume that duplicates are not allowed in the array.
 * Created by kaiscript on 2019/10/11.
 */
public class MinimumElementSortedAndRotatedArray {

    public static int findMinElement(int[] array) {
        int low = 0, high = array.length - 1;
        int mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            if(array[mid] < array[high]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        int arr[]={16,19,21,44,3,5,8,10};
        System.out.println("Minimum element in the array : " + findMinElement(arr));
    }


}
