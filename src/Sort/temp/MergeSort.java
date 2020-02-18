package Sort.temp;

/**
 * 归并排序
 * 时间公式：T(N) = 2*T(N/2) + N
 * 时间复杂度：O(N*lgN)
 * Created by kaiscript on 2019/6/25.
 */
public class MergeSort {

    public void mergeSort(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];
        while (i <= mid && j<= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            }
            else{
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        for (int l = 0; l < k; l++) {
            a[start + l] = temp[l];
        }

    }

    public void sort(int[] a,int start,int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);
        mergeSort(a, start, mid, end);
    }

    public static void main(String[] args) {
        int a[] = {80,30,60,40,20,10,23,70};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort0(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    // 归并排序
    //分治思想，递归地划分数组，那么最后一个数组只有一个数字，那必然有序。然后对2个数组进行排序。
    // merge(s,e) = merge(s,m) + merge(m+1,e)
    public void sort0(int[] a,int start,int end) {
        if (start >=end) {
            return;
        }
        int mid = (start + end) / 2;
        sort0(a, start, mid);
        sort0(a, mid + 1, end);
        mergeSort0(a, start, mid, end);
    }

    private void mergeSort0(int[] a, int start, int mid, int end) {
        //声明存用于放临时排序好的数组
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        //维护2个指针，比较2个无序数组，将小的数字放到临时数组中
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            }
            else{
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= end) {
            temp[k++] = a[j++];
        }
        for (k = 0; k < temp.length; k++) {
            a[start + k] = temp[k];
        }
    }


    //递归的定义
    public void sort1(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        sort1(nums, start, mid);
        sort1(nums, mid + 1, end);
        mergeSort1(nums, start, end, mid);
    }

    public void mergeSort1(int[] nums, int start, int end, int mid) {

        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j];
            }
            else
                temp[k++] = nums[i];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (k = 0; k < temp.length; k++) {
            nums[start + k] = temp[k];
        }

    }


}
