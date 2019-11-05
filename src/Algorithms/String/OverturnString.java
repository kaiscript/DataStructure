package Algorithms.String;
/**
 * 翻转句子中的全部单词，单词内容不变
 *@author Kaiscript
 *
 *2016年8月5日下午10:11:01
 */
public class OverturnString {
	
	/**
	 * 翻转字符串
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
