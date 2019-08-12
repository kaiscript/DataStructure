package Sort.temp;

/**
 * ð�����򡣴�ͷ��ʼ�������Ƚ�2����������������ƣ�����N�������ɰ�������������󡣹ʱ���N�μ����������
 * ʱ�临�Ӷ�O(n^2)
 * �ȶ�����
 * ԭ������
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
