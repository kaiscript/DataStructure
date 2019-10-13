package Array;

/**
 *
 * Given an array of integers representing stock price on single day, find max profit that can be earned by 1 transaction.
 So you need to find pair (buyDay,sellDay) where buyDay < = sellDay and it should maximise the profit. For example:


 int arr[]={14, 12, 70, 15, 99, 65, 21, 90};
 Max profit can be gain by buying at 1th day(0 based indexing) and sell at 4th day.
 Max profit = 99-12 =87
 * Created by kaiscript on 2019/10/13.
 */
public class StockBuySell {

    public static int calculateMaxProfit(int[] nums) {
        int lowestPrice = nums[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int profit = nums[i] - lowestPrice;
            if(nums[i] > lowestPrice){
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else if (nums[i] <= lowestPrice) {
                lowestPrice = nums[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = {14, 12, 70, 15, 99, 65, 21, 90};
        System.out.println(calculateMaxProfit(arr));
    }

}
