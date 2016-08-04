package Algorithms.DP;

import java.util.Scanner;

/**
 * 0-1���� ��DP��
 *@author Kaiscript
 *
 *2016��8��3������5:24:51
 */
public class ZeroOnePackage {
	/*3
	10
	5 4 3
	20 10 12*/
	/*״̬��d[i][j]   i:�ڼ�����ʯ    j����ǰ�ı����ռ�
	�����⼰���Ʒ��̣�  ��װ�뵱ǰ��ʯ��d[i][j] = d[i-1][j] + 1;
	      		 װ�뵱ǰ��ʯ�� d[i][j] = d[i-1][j-v[i-1]]+w[i-1];*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] v = new int[n];
		int[] w = new int[n];
		int[][] d = new int[n][c+1];
		int[] x = new int[n];//����Ƿ�װ��
		int[] dp = new int[c+1]; //ѹ���ռ�����
		for(int i=0;i<n;i++){
			v[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			w[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<=c;j++){
				d[i][j] = i==0 ? 0 : d[i-1][j];//i==0�����ʼ��Ϊ0.���� Ĭ�ϲ����뱦ʯ���������ǰ��d[i-1][j]
				
				if(i>0 && j>=v[i-1]){//�пռ�װ��ʯ������װ�뱦ʯ
					d[i][j] = d[i-1][j-v[i-1]]+w[i-1];  
				}
			}
		}
		
		/*---״̬������i�޹أ� ����i��ѹ���ռ�---start*/
		
		// ������ĵڶ���for��ķ��̿ɵã�d(i,j) = max{d(i-1,j),d(i-1,j-V+W)}
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
