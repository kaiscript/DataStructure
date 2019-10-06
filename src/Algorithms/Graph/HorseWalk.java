package Algorithms.Graph;
/**
 * ��n*n�������У���ֻ����"��"�֡����λ��(0,0)�����������̵�ÿһ����һ����ֻ��һ��
 *@author Kaiscript
 *
 *2016��8��11������3:53:17
 */
public class HorseWalk {
	
	public static int[][] move = {{1,2},{-1,2},{2,1},{-2,1},{2,-1},{-2,-1},{1,-2},{-1,-2}};
	
	public static int N = 5;
	public static int[][] book;
	public static int count =0 ;
	public static int res = 0;
	
	public static void dfs(int x,int y){
		if(count==N*N-1){
			res++;
			System.out.println("��"+res+"----");
			for(int i=0;i<book.length;i++){
				for(int j=0;j<book.length;j++)
					System.out.print(book[i][j]+" ");
				System.out.println();
			}
			System.out.println("--------");
			return;
		}
			
		int nextY,nextX;
		for(int i=0;i<move.length;i++){
			nextX = x+move[i][0];
			nextY = y+move[i][1];
			if(nextX>=0 && nextX < N && nextY>=0 && nextY<N && book[nextX][nextY]==0){
				count++;
				book[nextX][nextY] = count;
				dfs(nextX,nextY);
				book[nextX][nextY] = 0;
				count--;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[N];
		book = new int[N][N];
		for(int i=0;i<book.length;i++){
			for(int j=0;j<book.length;j++)
				book[i][j] =0;
		}
		dfs(0,0);
		System.out.println(res);
	}

}
