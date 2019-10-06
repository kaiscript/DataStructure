package Sort;
/**
 * 选择排序
 *@author Kaiscript
 *
 *2016年7月28日下午3:20:08
 */
public class SelectSort {
	
	
	/**
	 * N个数，遍历一次O(N),总共需要(N-1)!次，故时间复杂度为O(N^2)
	 * @param a
	 */
	public static void selectSort(int[] a){
		int i,j,min;
		
		for(i=0;i<a.length;i++){
			
			min = i;
			for(j=i+1;j<a.length;j++){
				if(a[j]<a[min])
					min = j;
			}
			
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
			
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = {12,54,4,67,143,56,324,87};
		selectSort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
	}

}
