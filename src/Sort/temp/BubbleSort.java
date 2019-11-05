package Sort.temp;

/**
 * 冒牌排序。从头开始遍历，比较2个数，将大的往后移，遍历N个数即可把最大的数放在最后。故遍历N次即可完成排序
 * 时间复杂度O(n^2)
 * 稳定排序
 * 原地排序
 * Created by kaiscript on 2019/6/20.
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {12,54,4,67,143,56,324,87};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
