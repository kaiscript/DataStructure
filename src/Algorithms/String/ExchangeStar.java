package Algorithms.String;
/**
 * 一个字符串包含星号和数字 ，把它的星号都放到开头
 *@author Kaiscript
 *
 *2016年8月6日下午4:51:57
 */
public class ExchangeStar {
	
	/**
	 * 也是从后往前遍历的思路，可以不用改变数字的顺序 
	 */
	public static String exchangeStar(String str){
		char[] strs = str.toCharArray();
		int j = str.length()-1;
		char[] s = new char[strs.length];
		for(int i=j;i>=0;i--){
			if(strs[i]!='*')
				s[j--] = strs[i];
		}
		for(int i = j;i>=0;i--){
			s[i] = '*';
		}
		return new String(s);
	}
	
	public static void main(String[] args) {
		String str = "**324*34*78***09";
		System.out.println(exchangeStar(str));
		
	}

}
