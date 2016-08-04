package Algorithms.DP;
/**
 * 最长公共子序列LCS
 *@author Kaiscript
 *
 *2016年8月1日下午5:50:42
 */
public class LCS {
	
	public static void main(String[] args) {
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";
		LCS(str1,str2);
	}
	
	public static void LCS(String x,String y){
		int length1 = x.length();
		int length2 = y.length();
		
		int[][] opt = new int[length1+1][length2+1];
		for(int i=length1-1;i>=0;i--){
			for(int j = length2-1;j>=0;j--){
				if(x.charAt(i)==y.charAt(j))
					opt[i][j] = opt[i+1][j+1]+1;
				else
					opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
				
			}
		}
		
		
		for(int i=0;i<length1;i++){
			for(int j=0;j<length2;j++){
				System.out.print(opt[i][j]+" ");
			}
			System.out.println();
		}
		System.out.print("LCS:");
		int i =0;
		int j =0;
		while(i<length1 && j<length2){
			if(x.charAt(i)==y.charAt(j)){
				System.out.print(x.charAt(i));
				i++;
				j++;
			}
			else if(opt[i+1][j]>=opt[i][j+1]){
				i++;
			}
			else
				j++;
		}
		
	}
	
}
