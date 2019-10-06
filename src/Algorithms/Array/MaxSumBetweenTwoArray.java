package Algorithms.Array;
/**
 * 求两个子数组最大的累加和
【题目】
给定一个数组，其中当然有很多的子数组，在所有两个子数组的组合中，找到相
加和最大的一组，要求两个子数组无重合的部分。最后返回累加和。
 *@author Kaiscript
 *
 *2016年8月4日下午4:32:05
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
		//r为辅助数组。从后往前计算[i,arr.length-1]的子数组最大和
		for(int i=arr.length-2;i>=0;i--){
			cur = cur<0?0:cur;
			cur +=arr[i];
			r[i] = Math.max(cur, r[i+1]);
		}
		
		int res = arr[0]+r[1];  //左右两个子数组的最大和
		int lmax = arr[0];
		cur = arr[0];
		//从前往后，结合r数组。计算子数组最大和，也就相当于计算两个子数组的最大和
		for(int i=1;i<arr.length-1;i++){
			cur = cur<0?0:cur;
			cur +=arr[i];
			lmax = Math.max(cur, lmax);
			res = Math.max(res, lmax+r[i+1]);
		}
		
		return res;
	}
	
}
