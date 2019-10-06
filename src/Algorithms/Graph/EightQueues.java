package Algorithms.Graph;
/**
 * 八皇后问题是在8*8的棋盘上放置8枚皇后，使得棋盘中每个横向、纵向、左上至右下斜向、右上至左下斜向均只有一枚皇后。
求解出所有摆法,一共有92种摆法
 *@author Kaiscript
 *
 *2016年8月11日下午12:24:00
 */
public class EightQueues {
	
	public static int N = 8;
	
	public static void display(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				if(a[i]==j)
					System.out.print(a[i]);
				else
					System.out.print("#");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int row,int[] a){
		for(int col=0;col<N;col++){
			if(isOk(row, col, a)){  //可以放，则标记，并进入下一行
				a[row] = col;
				if(row!=N-1){
					dfs(row+1,a);
				}
				else{
					display(a);
					System.out.println("-----------");
				}
			}
			
		}
		
	}
	
	/**
	 * 检测第row行col列能否放皇后
	 */
	public static boolean isOk(int row,int col,int[] a){
		for(int i=0;i<row;i++){ //  [0,row)行是已经放了皇后了的
			if(a[i]==col || row-i == Math.abs(a[i]-col)){ //看是否在同一列或者是斜线上
				return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		N = 8;
		int[] a = new int[N];
		dfs(0,a);
	}

}
