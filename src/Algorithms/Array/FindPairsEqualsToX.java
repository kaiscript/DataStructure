package Algorithms.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by kaiscript on 2019/10/13.
 */
public class FindPairsEqualsToX {

    public static void findPairsEqualsToX(int[] nums, int x) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int sum = 0;
        while (l < r) {
            sum = nums[l] + nums[r];
            if (sum == x) {
                System.out.println(nums[l] + " " + nums[r]);
                l++;
                r--;
            }
            else if (sum < x) {
                l++;
            }
            else
                r--;
        }
    }

    public static void findPairsEqualsToXUsingHash(int[] nums, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = x - nums[i];
            Integer index = map.get(diff);
            if (index != null && index != i) {
                System.out.println(nums[i] + " " + diff);
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {-40, -5, 1, 3, 6, 7, 4, 8, 20};
        findPairsEqualsToX(array, 7);
        System.out.println("-------------------");
        findPairsEqualsToXUsingHash(array, 7);
    }

}
