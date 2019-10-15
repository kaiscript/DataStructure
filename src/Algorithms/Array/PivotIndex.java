package Algorithms.Array;

/**
 * Created by kaiscript on 2019/10/13.
 */
public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == leftSum * 2) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {-1,-1,-1,-1,-1,-1};
//        int[] nums = {-1, -1, -1, 0, 1, 1};
        System.out.println(pivotIndex(nums));
    }

}
