package Algorithms.String;
/**
 * ��һ��0-1���������򣬿������⽻������λ�ã���������Ҫ���ٴν���
 *@author Kaiscript
 *
 *2016��8��5������10:31:44
 */
public class Overturn01String {
	
	public static int countLessOverturn(String str){
		int count = 0;
		for(int i=0,j = str.length()-1;i<str.length();i++){
			for(;i<j && str.charAt(i)=='0';i++);
			for(;i<j && str.charAt(j)=='1';j--);
			if(i<j)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String str = "010101111";
		System.out.println(countLessOverturn(str));
	}

}
