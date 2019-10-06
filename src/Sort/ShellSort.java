package Sort;
/**
 * 希尔排序
 *@author Kaiscript
 *
 *2016年9月6日上午11:02:16
 */
public class ShellSort {
	
	public static void shellSort(int[] a,int n){
		int gap,i,j;
		for(gap=n/2;gap>0;gap/=2){
			for(i=0;i<gap;i++){
				for(j=i+gap;j<n;j+=gap){
					if(a[j-gap]>a[j]){
						int temp = a[j];
						int k = j - gap;
						for(;k>=0 && a[k]>temp;k-=gap){
							a[k+gap] = a[k];
						}
						a[k+gap] = temp;
					}
				}
			}
			
		}
	}
	
	public static void shellSort2(int[] a,int n){
		int gap,j;
		for(gap=n/2;gap>0;gap/=2){
			for(j=gap;j<n;j++){ 
				if(a[j]<a[j-gap]){
					int temp = a[j];
					int k = j-gap;
					for(;k>=0 && a[k]>temp;k-=gap){
						a[k+gap] = a[k];
					}
					a[k+gap] =temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {31,121,54,4,12,43,67,231,67,324,87};
		shellSort2(a, a.length);
		for(int i:a){
			System.out.print(i+" ");
		}
	}

}
