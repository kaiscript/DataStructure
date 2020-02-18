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
     * ��������Ҳ�Ƿ��Ρ��ݹ��˼��
     * ������������ѡȡһ��pivot����С��pivot��������������ߣ����ڵķ��������ұߡ�
     * ���õĹ��̣�˼�����������ʹ�õķ����е����ƣ����ǽ����ֲ��뵽�����к��ʵ�λ��ʱ������Ҫ����������Ųλ�����ǽ�������
     * �����������ɺ󣬵ݹ�ض�pivot��ߺ��ұߵ������������Ĳ��������Բ��õ��Ƿ��ε�˼·
     * sort(s,e) = sort(s,m) + sort(m+1,e)
     * ʱ�乫ʽ�� T(N) = 2*T(N/2) + N�������ʱ�临�Ӷȣ�O(N*lgN)
     * ������������ÿ�ζ�ѡ�����һ������Ϊpivot����Ҫ����N�η���������һ�η�������ɨ��0~N-1�Σ�ƽ����N/2����������Ӷ���O(N^2)
     */
    public static void quickSort0(int[] a, int start, int end) {
        if(start >=end)
            return;
        int i = start;
        int j = end;
        //Ŀ�ľ��ǽ�pivot�ŵ����ʵ�λ�ã�������ߵ���С�������ұߵ���������
        int pivot = a[i];
        while (i < j) {
            //�Ӻ���ǰ�ң��ҵ���pivotС����
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
        //ʣ���±�Ϊi�Ŀӻ�û�����ʵ����pivot��λ��
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
