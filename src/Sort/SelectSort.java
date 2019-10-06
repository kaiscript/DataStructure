package Sort;
/**
 * ѡ������
 *@author Kaiscript
 *
 *2016��7��28������3:20:08
 */
public class SelectSort {
	
	
	/**
	 * N����������һ��O(N),�ܹ���Ҫ(N-1)!�Σ���ʱ�临�Ӷ�ΪO(N^2)
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
