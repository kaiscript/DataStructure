package Sort.temp;

/**
 * 插入排序
 * 将数组分为有序区和无序区。第一个数为有序区。然后拿第二个数(也即是无序区的第一个数)来与有序区的数作比较。插入到有序区中，再将第三个数插入到有序区。故需遍历N次。
 * 如果数组已经有序，则比较的时候发现“插入数”比有序区的数大，则不用排序，故最好复杂度O(N).
 * 如果数组倒序，则是最坏复杂度，则为O(N^2)
 * Created by kaiscript on 2019/8/11.
 */
public class InsertSort {


    /**
     * 划分无序区和有序区，以无序区的第一个数为基准，在有序区里找到比这个数小的坑位。
     * @param a
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) { //划分i开始的无序区
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j]; //要插入的数比 有序区的某个数 小。则将有序区的这个数向后挪，给比较的数挪出坑位
                }
                else {
                    break;
                }
            }
            //j--时又向前移动了一位，所以补回去
            a[j + 1] = temp;
        }
    }


    public void insertSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                }
                else
                    break;
            }
            nums[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {12,54,4,67,324,87};
        insertSort(a);
        for(int i:a){
            System.out.print(i+" ");
        }
    }

}
