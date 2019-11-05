package Algorithms.Array;

/**
 * Question 28 : Given an array containing zeroes, ones and twos only. Write a function to sort the given array in O(n) time complexity.
 * For example:
 * Input :
 * [1, 2, 2, 0, 0, 1, 2, 2, 1]
 *
 * Output :
 * [0, 0, 1, 1, 1, 2, 2, 2, 2]
 */
public class SortAnArrayOf012 {

    /**
     * 数值替代下标法
     * @param nums
     * @return
     */
    public int[] sort(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int[] ret = new int[nums.length];
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ret[k++] = i;
                count[i]--;
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        SortAnArrayOf012 sa = new SortAnArrayOf012();
        int[] nums = new int[]{1, 2, 2, 0, 0, 1, 2, 2, 1};
        for (int i : sa.sort(nums)) {
            System.out.print(i + " ");
        }

    }

}
