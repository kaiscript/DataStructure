package Algorithms.Array;
/**
 * 求数组中最大连续子数组的和
 *@author Kaiscript
 *
 *2016年8月4日下午4:48:23
 */
public class MaxSubArraySum {

	public static void main(String[] args) {
		int[] arr = { -11, -10, 6, 4, 5, 3, -7, -8, 3, 6, 9, 1, -7 };
		maxSum(arr);
	}
	//res为全局最大值，cur为当前的最大值
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
