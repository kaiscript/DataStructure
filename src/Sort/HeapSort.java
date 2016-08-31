package Sort;
/**
 * 由于每次重新恢复堆的时间复杂度为O(logN)，共N - 1次重新恢复堆操作，再加上前面建立堆时N / 2次向下调整，
 * 每次调整时间复杂度也为O(logN)。二次操作时间相加还是O(N * logN)。故堆排序的时间复杂度为O(N * logN)。
 *@author Kaiscript
 *
 *2016年8月18日下午12:19:26
 */
public class HeapSort {
	
	/**
	 * 从i开始向上调整小顶堆
	 * @param a
	 * @param i
	 */
	public static void minHeapFixup(int[] a,int i) {
		int p,temp;
		temp = a[i];
		p = (i-1)/2;
		while(p>=0 && i!=0){
			if(a[p]<=temp)
				break;
			a[i] = a[p];
			i = p;
			p = (p-1)/2;
		}
		a[i] = temp;
	}
	
	/**
	 * 从i开始向下调整小顶堆
	 * @param a
	 * @param i
	 */
	public static void minHeapFixdown(int[] a,int i){
		int j = 2*i+1;
		int temp = a[i];
		while(j<a.length){
			if(j<a.length-1 && a[j]>a[j+1])
				j++;
			
			if(a[j]>=temp)
				break;
			a[i] = a[j];
			i = j;
			j = 2*j+1;
		}
		a[i] = temp;
	} 
	
	
	public static void deleteTop(int[] a){
		a[0] = Integer.MAX_VALUE;
		swap(a,a.length-1,0);
		minHeapFixdown(a,0);
	}
	
	public static void swap(int[] a,int i,int j){
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	} 
	
	public static int[] insert(int[] a,int val){
		int[] temp = new int[a.length+1];
		for(int i=0;i<a.length;i++)
			temp[i] = a[i];
		temp[a.length] = val;
		minHeapFixup(temp, temp.length-1);
		return temp;
	}
	
	public static void main(String[] args) {
		int[] a = {40,10,30,15};
		for(int i=a.length/2-1;i>=0;i--) //堆排序 O(N*logN)
			minHeapFixdown(a,i);
		//--
		
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		
		System.out.println("\n---insert---");
		a = insert(a, 1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println("\n---delete---");
		deleteTop(a);
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		
	}

}
