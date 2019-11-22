package Algorithms.leetcode.binary;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * @author chenkai
 * @date: 2019-11-22
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //mid比头尾大，则看target是否在 [mid+1,end]这个区间中。是的话右区间有序,则在右区间找
            if (nums[mid] < nums[start] || nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else
                    end = mid - 1;
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }
                else
                    start = mid + 1;
            }
            else
                end--;
        }

        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();
        System.out.println(searchInRotatedSortedArrayII.search(nums, 3));
    }

    /**
     *
     *         mid = (start + end) / 2;
     *         if (nums[mid] == target) {
     *             return true;
     *         }
     *         //If we know for sure right side is sorted or left side is unsorted
     *         if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
     *             if (target > nums[mid] && target <= nums[end]) {
     *                 start = mid + 1;
     *             } else {
     *                 end = mid - 1;
     *             }
     *             //If we know for sure left side is sorted or right side is unsorted
     *         } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
     *             if (target < nums[mid] && target >= nums[start]) {
     *                 end = mid - 1;
     *             } else {
     *                 start = mid + 1;
     *             }
     *             //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
     *             //any of the two sides won't change the result but can help remove duplicate from
     *             //consideration, here we just use end-- but left++ works too
     *         } else {
     *             end--;
     *         }
     */
}
