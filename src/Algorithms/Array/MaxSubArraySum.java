package Algorithms.Array;
/**
 * ���������������������ĺ�
 *@author Kaiscript
 *
 *2016��8��4������4:48:23
 */
public class MaxSubArraySum {

	public static void main(String[] args) {
		int[] arr = { -11, -10, 6, 4, 5, 3, -7, -8, 3, 6, 9, 1, -7 };
		maxSum(arr);
	}
	//resΪȫ�����ֵ��curΪ��ǰ�����ֵ
	public static int maxSum(int[] arr){
		int cur = 0;
		int res = arr[0];
		for(int i=0;i<arr.length;i++){
			cur = cur<=0?0:cur;
			cur +=arr[i];
			res = Math.max(cur, res);
		}
		System.out.println(res);
		return 0;
	}
	
}
