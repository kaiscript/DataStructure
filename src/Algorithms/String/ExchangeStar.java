package Algorithms.String;
/**
 * һ���ַ��������Ǻź����� ���������ǺŶ��ŵ���ͷ
 *@author Kaiscript
 *
 *2016��8��6������4:51:57
 */
public class ExchangeStar {
	
	/**
	 * Ҳ�ǴӺ���ǰ������˼·�����Բ��øı����ֵ�˳�� 
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
