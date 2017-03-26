package leetcode_algorithm;

import java.util.Arrays;

/**

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

        Your algorithm's runtime complexity must be in the order of O(log n).

        If the target is not found in the array, return [-1, -1].

        For example,
        Given [5, 7, 7, 8, 8, 10] and target value 8,
        return [3, 4].

*/

public class q034_SearchForARange {

    public static void main(String[] args) {
        //int[] result = new q001_TwoSum().searchRange(new int[]{5 , 7 ,7,  8 , 8 , 10} , 8);
        //System.out.println(ArraySort.toString(result));
        int[] result = new q034_SearchForARange().searchRange(new int[]{1}, 1);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 解法1 (个人解法)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end)/2;
        while (start <= end) {
            if(nums[mid] < target) start = mid + 1;
            if(nums[mid] > target) end = mid - 1;
            if(nums[mid] == target){
                start = end = mid;
                while (start>-1 && nums[start] == target) start--;
                while (end < nums.length  && nums[end] == target) end++;
                return new int[]{start+1, end-1};
            }
            mid = (start + end)/2;
        }
        return new int[]{-1 , -1};
    }


    /**
     * 解法2
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start , firstGreaterEqual(nums , target + 1) - 1};
    }

    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0 ;
        int high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if(A[mid] < target){
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }


}
