package Algorithms.DP;

import java.util.Scanner;

/**
 * 0-1背包 （DP）
 *@author Kaiscript
 *
 *2016年8月3日下午5:24:51
 */
public class ZeroOnePackage {
	/*3
	10
	5 4 3
	20 10 12*/
	/*状态：d[i][j]   i:第几个宝石    j：当前的背包空间
	子问题及递推方程：  不装入当前宝石：d[i][j] = d[i-1][j] + 1;
	      		 装入当前宝石： d[i][j] = d[i-1][j-v[i-1]]+w[i-1];*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] v = new int[n];
		int[] w = new int[n];
		int[][] d = new int[n][c+1];
		int[] x = new int[n];//标记是否装入
		int[] dp = new int[c+1]; //压缩空间的情况
		for(int i=0;i<n;i++){
			v[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			w[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<=c;j++){
				d[i][j] = i==0 ? 0 : d[i-1][j];//i==0，则初始化为0.否则 默认不填入宝石，让其等于前面d[i-1][j]
				
				if(i>0 && j>=v[i-1]){//有空间装宝石，则尝试装入宝石
					d[i][j] = d[i-1][j-v[i-1]]+w[i-1];  
				}
			}
		}
		
		/*---状态方程与i无关， 忽略i，压缩空间---start*/
		
		// 由上面的第二个for里的方程可得：d(i,j) = max{d(i-1,j),d(i-1,j-V+W)}
		/*for(int i=0;i<n;i++){
			for(int j=c;j>=0;j--){
				if(i>0 && j>=v[i-1])
					dp[j] = dp[j-v[i-1]]+w[i-1];
			}
		}
		System.out.println("max value:"+dp[c-1]);*/
		
		/*---end---*/
		
		System.out.println("max value:"+d[n-1][c]);
		int j = c;
		for(int i=n-1;i>0;i--){
			if(d[i][j]>d[i-1][j]){
				x[i] = 1;
				j = j-v[i];
			}
		}
		for(int i=0;i<x.length;i++){
			if(x[i]==1)
				System.out.println("space:"+v[i]+" value:"+w[i]);
		}
		
	}

}
