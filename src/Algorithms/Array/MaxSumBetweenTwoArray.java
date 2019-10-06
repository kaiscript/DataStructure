package Algorithms.Array;
/**
 * �����������������ۼӺ�
����Ŀ��
����һ�����飬���е�Ȼ�кܶ�������飬���������������������У��ҵ���
�Ӻ�����һ�飬Ҫ���������������غϵĲ��֡���󷵻��ۼӺ͡�
 *@author Kaiscript
 *
 *2016��8��4������4:32:05
 */
public class MaxSumBetweenTwoArray {
	
	public static void main(String[] args) {
		int[] arr = { -11, -10, 6, 4, 5, 3, -7, -8, 3, 6, 9, 1, -7 };
		System.out.println(maxSum(arr));
	}
	
	public static int maxSum(int[] arr){
		if(arr==null || arr.length<2)
			return 0;
		
		int cur = arr[arr.length-1];
		int[] r = new int[arr.length];
		r[arr.length-1] = arr[arr.length-1];
		//rΪ�������顣�Ӻ���ǰ����[i,arr.length-1]������������
		for(int i=arr.length-2;i>=0;i--){
			cur = cur<0?0:cur;
			cur +=arr[i];
			r[i] = Math.max(cur, r[i+1]);
		}
		
		int res = arr[0]+r[1];  //�������������������
		int lmax = arr[0];
		cur = arr[0];
		//��ǰ���󣬽��r���顣�������������ͣ�Ҳ���൱�ڼ������������������
		for(int i=1;i<arr.length-1;i++){
			cur = cur<0?0:cur;
			cur +=arr[i];
			lmax = Math.max(cur, lmax);
			res = Math.max(res, lmax+r[i+1]);
		}
		
		return res;
	}
	
}
