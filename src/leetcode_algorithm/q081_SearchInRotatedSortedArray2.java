package leetcode_algorithm;

/**
 * Follow up for "Search in Rotated Sorted ArraySort":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Write a function to determine if a given target is in the array.
 * <p>
 * The array may contain duplicates.
 */

public class q081_SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        q081_SearchInRotatedSortedArray2 solution = new q081_SearchInRotatedSortedArray2();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8));
        System.out.println(solution.search(new int[]{3, 1, 1}, 3));
        System.out.println(solution.search(new int[]{1, 3, 1, 1, 1}, 3));
        System.out.println(solution.search(new int[]{1, 1, 3, 1}, 3));
        System.out.println(solution.search(new int[]{3, 1}, 1));
    }

    /**
     * 解法1
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        return backSearch(nums, target, 0, nums.length - 1);
    }

    private boolean backSearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            //mid左半部分是正常排序
            if (nums[start] < nums[mid] || nums[end] < nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) end = mid - 1;
                else start = mid + 1;
                //mid右半部分是正常排序
            } else if (nums[end] > nums[mid] || nums[start] > nums[mid]) {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            } else {
                //nums[start] == nums[end] == nums[mid]这种情况，消除重复数字
                end--;
            }
        }
        return false;
    }


}
