package Algorithms.Array;

/**
 * 747. �������������������������
 * ��һ������������nums�У����Ǵ���һ�����Ԫ�� ��

 ���������е����Ԫ���Ƿ�������������ÿ���������ֵ�������

 ����ǣ��򷵻����Ԫ�ص����������򷵻�-1��

 ʾ�� 1:

 ����: nums = [3, 6, 1, 0]
 ���: 1
 ����: 6����������, ���������е���������,
 6��������������Ԫ�ص�������6��������1, �������Ƿ���1.
 ?

 ʾ�� 2:

 ����: nums = [1, 2, 3, 4]
 ���: -1
 ����: 4û�г���3��������, �������Ƿ��� -1.

 * Created by kaiscript on 2019/10/13.
 */
public class DominantIndex {

    public static int dominantIndex(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
                index = i;
            }
            else{
                if (nums[i] > secondLargest) {
                    secondLargest = nums[i];
                }
            }
        }
        return largest >= (2 * secondLargest) ? index : -1;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 6, 1, 0};
//        int[] nums = {0,0,0,1};
        int[] nums = {1};
        System.out.println(dominantIndex(nums));
    }

}
