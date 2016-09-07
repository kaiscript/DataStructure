package Sort;
/**
 * Ͱ����
 *@author Kaiscript
 *
 *2016��9��7������10:24:47
 */
public class BucketSort {
	
	public static void bucketSort(int[] a,int max){
		int[] bucket = new int[max+1];
		//ͳ����bucket��
		for(int i:a){
			bucket[i]++;
		}
		
		//ͳ�Ʋ�����
		for(int i=0,j=0;i<bucket.length;i++){
			while(bucket[i]-->0){
				a[j++] = i; 
			}
		}
		
	}
	
	public static int getMax(int[] a){
		int max = Integer.MIN_VALUE;
		for(int i:a){
			if(i>max)
				max = i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {12,54,4,67,143,56,324,87};
		bucketSort(a, getMax(a));
		for(int i:a)
			System.out.print(i+" ");
	}

}
