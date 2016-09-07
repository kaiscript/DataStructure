package Sort;
/**
 * 快速排序。
 * 快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。
 * <br>(01) 为什么最少是lg(N+1)次？快速排序是采用的分治法进行遍历的，我们将它看作一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的定义，它的深度至少是lg(N+1)。因此，快速排序的遍历次数最少是lg(N+1)次。
 * <br>(02) 为什么最多是N次？这个应该非常简单，还是将快速排序看作一棵二叉树，它的深度最大是N。因此，快读排序的遍历次数最多是N次。
 *@author Kaiscript
 *
 *2016年7月26日下午5:56:15
 */
public class QuickSort {
	
	public static void quickSort(int[] a,int left,int right){
		if(left<right){
			int i = left;
			int j = right;
			int x = a[i];
			
			while(i<j){
				while(i<j && a[j]>x)
					j--;
				if(i<j)
					a[i++] = a[j];
				
				while(i<j && a[i]<=x)
					i++;
				if(i<j)
					a[j--] = a[i];
				
			}
			a[i] = x;
			quickSort(a, left, i-1);
			quickSort(a, i+1,right);
		}
	}
	
	public static void main(String[] args) {
		int a[] = {30,40,60,10,20,50};
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println();
		quickSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
