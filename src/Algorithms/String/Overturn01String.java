package Algorithms.String;
/**
 * 把一个0-1串进行排序，可以任意交换两个位置，问最少需要多少次交换
 *@author Kaiscript
 *
 *2016年8月5日下午10:31:44
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
