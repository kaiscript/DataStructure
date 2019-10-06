package Sort;
/**
 * �鲢����
 * ��������Ԫ����ҪO(n),�鲢�Ƕ�����,���߶�logN,�ʸ��Ӷ�ΪO(N*logN)
 *@author Kaiscript
 *
 *2016��7��25������10:32:33
 */
public class MergeSort {
	
	public static void merge(int[] a,int start,int mid,int end){
		int[] tmp = new int[end-start+1];
		int i = start;
		int j = mid+1;
		int k = 0;
		
		while(i<=mid && j<=end){
			tmp[k++] = a[i]<a[j]?a[i++]:a[j++];
		}
		while(i<=mid)
			tmp[k++] = a[i++];
		
		while(j<=end)
			tmp[k++] = a[j++];
		
		for(i=0;i<k;i++){
			a[start+i] = tmp[i];
		}
		
	}
	
	/**
	 * �������¹鲢
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void mergeSort(int[] a, int start, int end){
		if(a==null || end<=start)
			return;
		
		int mid = (start+end)/2;
		mergeSort(a, start, mid);
		mergeSort(a, mid+1, end);
		
		merge(a, start, mid, end);
	}
	
	
	public static void main(String[] args) {
		int a[] = {80,30,60,40,20,10,23,70};
		mergeSort(a, 0, a.length-1);
//		mergeSortDown2Up(a);
		for(int i:a){
			System.out.print(i+" ");
		}
	}

}
