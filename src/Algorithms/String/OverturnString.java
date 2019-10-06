package Algorithms.String;
/**
 * ��ת�����е�ȫ�����ʣ��������ݲ���
 *@author Kaiscript
 *
 *2016��8��5������10:11:01
 */
public class OverturnString {
	
	/**
	 * ��ת�ַ���
	 * @param str
	 * @return
	 */
	public static String overturn(String str){
		char[] strs = str.toCharArray();
		int i = 0;
		int j = strs.length-1;
		while(i<j){
			swap(strs,i++,j--);
		}
		return new String(strs);
	}
	
	private static void swap(char[] strs,int i, int j) {
		char tmp = strs[i];
		strs[i] = strs[j];
		strs[j] = tmp;
	}

	public static void main(String[] args) {
		String str = "I'm a student.";
		
		String[] ss = overturn(str).split(" ");
		for(String s:ss){
			System.out.print(overturn(s)+" ");
		}
	}
	
	
	
}
