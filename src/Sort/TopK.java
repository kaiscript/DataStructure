package Sort;


/**
 * ���ҵ�K���Ԫ�ء�
 * ���ÿ��������˼·��ÿһ�ο�������ķ������������Ὣ�����Ϊ2��partition����ߵ�partition��pivotС���ұߵ������pivot��
 * pivot�������е�N��ģ���ôֻҪ�Ƚ����N��ҪѰ�ҵ�K�Ƿ���ȡ�K��NС���������ߵ�������п��������ҳ�pivot��λ�ã�K��N����������ұߵ�������п��������ҳ�pivot��λ�á�
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
        return i;
    }

}
