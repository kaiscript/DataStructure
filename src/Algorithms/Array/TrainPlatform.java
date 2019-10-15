package Algorithms.Array;

/**
 * Problem:
 You are given arrival and departure time of trains reaching to a particular station.
 You need to find minimum number of platforms required to accommodate the trains at any point of time.
 For example:

 arrival[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00}
 departure[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}
 No. of platforms required in above scenario = 4
 * Created by kaiscript on 2019/10/13.
 */
public class TrainPlatform {

    public static int findPlatformsRequiredForStation(int[] arrival, int[] departure, int n) {
        int i = 0, j = 0;
        int need = 0;
        int requirePlatform = 0;
        while (i < n && j < n) {
            //到达时间小于离开时间，说明占了车站一个坑了
            if (arrival[i] < departure[j]) {
                need++;
                i++;
                if (need > requirePlatform) {
                    requirePlatform = need;
                }
            }
            else {
                j++;
                need--;
            }
        }
        return requirePlatform;
    }

    public static void main(String[] args) {
        int[] arr = {100, 140, 150, 200, 215, 400};
        int[] dep = {110, 300, 210, 230, 315, 600};
        System.out.println(findPlatformsRequiredForStation(arr, dep, 6));
    }

}
