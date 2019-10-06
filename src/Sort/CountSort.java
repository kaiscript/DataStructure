package Sort;
/**
 * ��������
 *@author Kaiscript
 *
 *2016��9��7������12:48:19
 */
public class CountSort {
	
	public static int getMax(int[] a){
		int max = Integer.MIN_VALUE;
		for(int i:a){
			if(i>max)
				max = i;
		}
		return max;
	}
	
	public static void countSort(int[] a){
		int[] temp = new int[a.length+1]; //r[]
		int[] bucket = new int[getMax(a)+1];//ȡ�����ֵ+1����֤bucket�ǹ���� 
		
		for(int i=0;i<a.length;i++)
			bucket[a[i]]++; //�����ֶ�Ӧ��Ͱ��������1   :c[]
		
		for(int i=1;i<bucket.length;i++){
			bucket[i] += bucket[i-1]; //�ۼ����м��������Ĺ��ļ�������ͱ�ʾ ÿ��Ԫ������������е�λ��
		}
		
		for(int i = a.length-1;i>=0;i--){ //�Ӻ�����ǰ��֤���ȶ���
			temp[bucket[a[i]]-1] = a[i];// bucket[a[i]]-1 �ʹ���С�ڵ���Ԫ��a[i]��Ԫ�ظ���������a[i]��bucket��λ��
			bucket[a[i]]--; //����Ҳ���Ƕ�Ӧ��λ��-1
			
		}
		
		for(int i =0;i<a.length;i++){
			a[i] = temp[i];
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = {12,54,4,67,143,56,324,87};
		countSort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
	}

}
