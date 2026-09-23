class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        for (int n : nums)
            total += n;

        int target = total - x;
        int left = 0, sum = 0, maxLen = -1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left++];
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}
