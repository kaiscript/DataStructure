package Sort;
/**
 * 插入排序
 *@author Kaiscript
 *
 *2016年7月28日下午2:32:58
 */
public class InsertSort {
	
	
	/**
	 * N个数,遍历一趟需要O(N)。需要遍历(N-1)!次
	 * 故时间复杂度O(N^2)
	 * @param a
	 */
	public static void insertSort(int[] a){
		int i,j,k;
		for(i =0;i<a.length;i++){
			
			for(j=i-1;j>=0;j--)
				if(a[j]<a[i])
					break;
			
			int tmp = a[i];
			for(k = i-1;k>j;k--){
				a[k+1] = a[k];
			}
			a[k+1] = tmp;
		}
		
	}
	
	public static void insertSort2(int[] a){
		int i,j;
		for(i=1;i<a.length;i++){
			if(a[i]<a[i-1]){
				int temp = a[i];
				for(j=i-1;j>=0 && a[j]>temp;j--)
					a[j+1] = a[j];
				
				a[j+1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {12,54,4,67,324,87};
		insertSort2(a);
		for(int i:a){
			System.out.print(i+" ");
		}
	}

}
