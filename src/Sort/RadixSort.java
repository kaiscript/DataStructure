package Sort;
/**
 *@author Kaiscript
 *
 *2016��9��7������11:03:09
 */
public class RadixSort {
	
	public static int getMax(int[] a){
		int max = Integer.MIN_VALUE;
		for(int i:a){
			if(i>max)
				max = i;
		}
		return max;
	}
	/**
	 * ��ʱ���鱣���ź����bucket��ֵ
	 * bucket[] ����ͳ�����ֳ��ֵĴ���
	 * exp ����λ��
	 */
			
	public static void countSort(int[] a,int exp){
		int[] output = new int[a.length];
		int[] bucket = new int[10];  //0~9
		//ͳ��Ͱ�����ֵĸ���
		for(int i=0;i<a.length;i++)
			bucket[(a[i]/exp)%10]++;
		
		for(int i=1;i<bucket.length;i++)
			bucket[i] +=bucket[i-1];
		
		for(int i=a.length-1;i>=0;i--){
			output[bucket[(a[i]/exp)%10]-1] = a[i];
			bucket[(a[i]/exp)%10]--;
		}
		
		for(int i=0;i<a.length;i++)
			a[i] = output[i];
		
	}
	
	public static void radixSort(int[] a){
		int exp;
		int max = getMax(a);
		for(exp = 1;max/exp>0;exp*=10){
			countSort(a, exp);
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = {12,54,4,67,143,56,324,87};
		radixSort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
	}

}
