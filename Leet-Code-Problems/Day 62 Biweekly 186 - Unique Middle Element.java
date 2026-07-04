class Solution {
    public boolean isMiddleElementUnique(int[] nums) {

        int mid = nums[nums.length / 2];
        int count = 0;

        for (int num : nums) {
            if (num == mid) {
                count++;
            }
        }

        return count == 1;
    }
}©leetcode
