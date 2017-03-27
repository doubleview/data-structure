package leetcode_algorithm;

/**

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        You are given a target value to search. If found in the array return its index, otherwise return -1.

        You may assume no duplicate exists in the array.

        Subscribe to see which companies asked this question

*/

public class q033_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new q033_SearchInRotatedSortedArray().search(nums, 0));
        System.out.println(new q033_SearchInRotatedSortedArray().search(nums, 4));
        System.out.println(new q033_SearchInRotatedSortedArray().search(nums, 5));
    }


    /**
     * ½â·¨1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[start])
                    end = mid -  1;
                else
                    start = mid+1;
            }

            if (nums[mid] <= nums[end]) {
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
