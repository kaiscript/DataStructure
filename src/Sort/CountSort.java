package Sort;
/**
 * 计数排序
 *@author Kaiscript
 *
 *2016年9月7日下午12:48:19
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
		int[] bucket = new int[getMax(a)+1];//取得最大值+1，保证bucket是够大的 
		
		for(int i=0;i<a.length;i++)
			bucket[a[i]]++; //在数字对应的桶里数量加1   :c[]
		
		for(int i=1;i<bucket.length;i++){
			bucket[i] += bucket[i-1]; //累加所有计数。更改过的计数数组就表示 每个元素在输出数组中的位置
		}
		
		for(int i = a.length-1;i>=0;i--){ //从后面往前保证了稳定性
			temp[bucket[a[i]]-1] = a[i];// bucket[a[i]]-1 就代表小于等于元素a[i]的元素个数，就是a[i]在bucket的位置
			bucket[a[i]]--; //计数也就是对应的位置-1
			
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
