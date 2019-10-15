package Algorithms.Array;

import java.util.Arrays;

/**
 * Created by kaiscript on 2019/10/13.
 */
public class FindPairClosestToZero {

    static void findPairWithMinSum(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int minL = 0, minR = r;
        Arrays.sort(nums);

        while (l < r) {
            sum = nums[l] + nums[r];
            if (Math.abs(sum) < Math.abs(min)){
                min = sum;
                minL = l;
                minR = r;
            }
            if(sum < 0){
                l++;
            }
            else{
                r--;
            }
        }
        System.out.println(nums[minL]);
        System.out.println(nums[minR]);
    }

    public static void main(String[] args) {
        int[] array = {1, 30, -5, 70, -8, 20, -40, 60};
        findPairWithMinSum(array);
    }

}
