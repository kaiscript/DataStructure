package Algorithms.String;
/**
 * ɾ��һ���ַ��������е�a��������b
 *@author Kaiscript
 *
 *2016��8��5������10:45:50
 */
public class DeleteAndCopy {
	//�Ӻ���ǰ������˼·
	//������������鲻����
	//һ��������ǣ��Ȱ� ������Ҫɾ������Щ�ַ�ת�Ƶ��µ����飬��ͳ����Ҫ���Ƶ��Ǹ��ַ��ĸ������Ӻ���ǰ�����µ����飬����  ����Ҫ���Ƶ��Ǹ��ַ�����
	//���Ա�������ô�ǰ�������ʱ������ʱ�����ǰ����ַ��滻��������ַ��Ĵ������������Ҳ���ԣ������Ʋ������򣬵����Ӷ�̫��
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
