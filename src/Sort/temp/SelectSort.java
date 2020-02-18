package Sort.temp;


/**
 * 选择排序
 * 将数据分为有序区和无序区，遍历数组，将无序区中最小的数放至无序区的第一个位置，也就是有序区后面的第一个位置。这样前N个数就有序了。遍历N^2次，便可使数组有序
 * 因为遍历一次无序区只能排序一个最小的，故最坏最好时间复杂度都是O(N^2)
 * Created by kaiscript on 2019/6/20.
 */
public class SelectSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j]< a[min]){
                    min = j;
                }
            }
            if (i != min) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {12,54,4,67,143,56,324,87};
        selectSort(a);
        for(int i:a){
            System.out.print(i+" ");
        }
    }


}
