package Sort.temp;

/**
 * Created by kaiscript on 2019/6/23.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,3,4,5};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
//        quickSort(a, 0, a.length - 1);
        quickSort1(a, 0, a.length - 1);
    }

    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i = l;
            int j = r;
            int x = a[i];
            while (i < j) {
                while (i < j && a[j] >= x) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                while (i < j && a[i] < x) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }

    }

    /**
     * 快速排序，也是分治、递归的思想
     * 首先在数组中选取一个pivot，将小于pivot的数放在它的左边，大于的放在它的右边。
     * 放置的过程，思想跟插入排序使用的方法有点类似，就是将数字插入到数组中合适的位置时，不需要将其他数据挪位，而是交换数字
     * 当这个过程完成后，递归地对pivot左边和右边的数组进行上面的操作。所以采用的是分治的思路
     * sort(s,e) = sort(s,m) + sort(m+1,e)
     * 时间公式： T(N) = 2*T(N/2) + N，故最好时间复杂度：O(N*lgN)
     * 假如数组有序，每次都选择最后一个数作为pivot，则要进行N次分区操作，一次分区操作扫描0~N-1次（平均是N/2），故最坏复杂度是O(N^2)
     */
    public static void quickSort0(int[] a, int start, int end) {
        if(start >=end)
            return;
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
        quickSort0(a, start, i-1);
        quickSort0(a, i + 1, end);
    }


    public static void quickSort1(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        quickSort1(nums, start, i - 1);
        quickSort1(nums, i + 1, end);

    }

}
