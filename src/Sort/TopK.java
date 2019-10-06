package Sort;


/**
 * 查找第K大的元素。
 * 利用快速排序的思路。每一次快速排序的分区操作，都会将数组分为2个partition，左边的partition比pivot小，右边的区间比pivot大。
 * pivot是数组中第N大的，那么只要比较这个N和要寻找的K是否相等。K比N小则继续在左边的区间进行快速排序，找出pivot的位置，K比N大则继续在右边的区间进行快速排序，找出pivot的位置。
 * Created by kaiscript on 2019/8/25.
 */
public class TopK {

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5};
        System.out.println(findKth(a, 0, a.length - 1, 3));
    }

    public static int findKth(int[] a, int start, int end, int k) {
        int pivot = quickSort(a, start, end);
        if (pivot + 1 < k) {
            return findKth(a, pivot + 1, end, k);
        } else if (pivot + 1 > k) {
            return findKth(a, start, pivot - 1, k);
        }
        else
            return a[pivot];
    }


    public static int quickSort(int[] a, int start, int end) {
        int i = start;
        int j = end;
        //目的就是将pivot放到合适的位置，并且左边的数小于它，右边的数大于它
        int pivot = a[i];
        while (i < j) {
            //从后往前找，找到比pivot小的数
            while (i < j && a[j] >= pivot) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < pivot) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        //剩下下标为i的坑还没人填，其实就是pivot的位置
        a[i] = pivot;
        return i;
    }

}
