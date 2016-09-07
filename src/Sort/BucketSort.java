package Sort;
/**
 * 桶排序
 *@author Kaiscript
 *
 *2016年9月7日上午10:24:47
 */
public class BucketSort {
	
	public static void bucketSort(int[] a,int max){
		int[] bucket = new int[max+1];
		//统计在bucket里
		for(int i:a){
			bucket[i]++;
		}
		
		//统计并排序
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
