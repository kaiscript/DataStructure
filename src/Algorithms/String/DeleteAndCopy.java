package Algorithms.String;
/**
 * 删除一个字符串中所有的a，并复制b
 *@author Kaiscript
 *
 *2016年8月5日下午10:45:50
 */
public class DeleteAndCopy {
	//从后往前遍历的思路
	//假设给定的数组不够大
	//一般的做法是，先把 不是需要删除的那些字符转移到新的数组，再统计需要复制的那个字符的个数。从后往前遍历新的数组，复制  “需要复制的那个字符”，
	//可以避免如果用从前往后遍历时，复制时，会把前面的字符替换掉后面的字符的错误。修正这错误也可以，用类似插入排序，但复杂度太大
	public static String othersideDo(String str){
		int numb = 0;
		char[] raw = str.toCharArray();
		int n = 0;
		for(int i = 0;i<raw.length;i++){
			if(raw[i]!='a')
				raw[n++] = raw[i];
			if(raw[i]=='b')
				numb++;
		}
		int newLength = n+1+numb;
		
		char[] s = new char[newLength];
		int j = n;
		for(int i = newLength-1;j>=0;j--){
			s[i--] = raw[j];
			if(str.charAt(j)=='b'){
				s[i--] = 'b';
			}
			
		}
		return new String(s);
	}
	
	public static void main(String[] args) {
		String str = "asabbrbbbssa";
		System.out.println(othersideDo(str));
	}

}
