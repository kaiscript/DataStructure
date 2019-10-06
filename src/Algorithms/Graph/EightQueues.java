package Algorithms.Graph;
/**
 * �˻ʺ���������8*8�������Ϸ���8ö�ʺ�ʹ��������ÿ��������������������б������������б���ֻ��һö�ʺ�
�������аڷ�,һ����92�ְڷ�
 *@author Kaiscript
 *
 *2016��8��11������12:24:00
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
			if(isOk(row, col, a)){  //���Էţ����ǣ���������һ��
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
	 * ����row��col���ܷ�Żʺ�
	 */
	public static boolean isOk(int row,int col,int[] a){
		for(int i=0;i<row;i++){ //  [0,row)�����Ѿ����˻ʺ��˵�
			if(a[i]==col || row-i == Math.abs(a[i]-col)){ //���Ƿ���ͬһ�л�����б����
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
