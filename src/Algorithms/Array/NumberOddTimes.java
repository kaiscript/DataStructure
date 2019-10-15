package Algorithms.Array;

/**
 * Problem:
 You are given a array of integer. All numbers occur even number of times except one.
 You need to find the number which occurs odd number of time. You need to solve it with o(n) time complexity and o(1) space complexity.
 For example:

 int array[] = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
 Number which occurs odd number of times is : 50

 * Created by kaiscript on 2019/10/13.
 */
public class NumberOddTimes {

    public static int getOddTimesElement(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
        System.out.println(getOddTimesElement(array));
    }


}
