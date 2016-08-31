package Sort;
/**
 * ����ÿ�����»ָ��ѵ�ʱ�临�Ӷ�ΪO(logN)����N - 1�����»ָ��Ѳ������ټ���ǰ�潨����ʱN / 2�����µ�����
 * ÿ�ε���ʱ�临�Ӷ�ҲΪO(logN)�����β���ʱ����ӻ���O(N * logN)���ʶ������ʱ�临�Ӷ�ΪO(N * logN)��
 *@author Kaiscript
 *
 *2016��8��18������12:19:26
 */
public class HeapSort {
	
	/**
	 * ��i��ʼ���ϵ���С����
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
	 * ��i��ʼ���µ���С����
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
		for(int i=a.length/2-1;i>=0;i--) //������ O(N*logN)
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
