package Sort.temp;

/**
 * ��������
 * �������Ϊ������������������һ����Ϊ�����������ڶ�����(Ҳ�����������ĵ�һ����)���뵽�������У��ٽ������������뵽���������������N�Ρ�
 * ��������Ѿ�������Ƚϵ�ʱ���������������ȡ��Ƚ�����С���������򣬹���ø��Ӷ�O(N).
 * ������鵹����������Ӷȣ���ΪO(N^2)
 * Created by kaiscript on 2019/8/11.
 */
public class InsertSort {


    /**
     * �����������������������������ĵ�һ����Ϊ��׼�������������ҵ��������С�Ŀ�λ��
     * @param a
     */
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) { //����i��ʼ��������
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j]; //���������� �� Ҫ�Ƚϵ��� ������ǰŲ�����Ƚϵ���Ų����λ
                }
                else {
                    break;
                }
            }
            //j--ʱ����ǰ�ƶ���һλ�����Բ���ȥ
            a[j + 1] = temp;
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
