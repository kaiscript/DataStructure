package Algorithms.Array;

/**
 * Created by kaiscript on 2019/10/6.
 */
public class FindSecondLargest {

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 1, 4, 2};
        System.out.println(findSecondLargest(arr));
    }

    public static int findSecondLargest(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > highest) {
                secondHighest = highest;
                highest = array[i];
            } else if (array[i] > secondHighest) {
                secondHighest = array[i];
            }
        }
        return secondHighest;
    }

}
