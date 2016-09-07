package Sort;
/**
 * ��������
 * ���������ʱ�临�Ӷ�����������O(N2)��ƽ����ʱ�临�Ӷ���O(N*lgN)��
 * <br>(01) Ϊʲô������lg(N+1)�Σ����������ǲ��õķ��η����б����ģ����ǽ�������һ�ö�����������Ҫ�����Ĵ������Ƕ���������ȣ���������ȫ�������Ķ��壬�������������lg(N+1)����ˣ���������ı�������������lg(N+1)�Ρ�
 * <br>(02) Ϊʲô�����N�Σ����Ӧ�÷ǳ��򵥣����ǽ�����������һ�ö�������������������N����ˣ��������ı������������N�Ρ�
 *@author Kaiscript
 *
 *2016��7��26������5:56:15
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
