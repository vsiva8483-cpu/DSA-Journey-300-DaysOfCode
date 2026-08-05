class Solution {
    
    public int countSubarray(int[] arr, int l, int r) {
        return count(arr, r) - count(arr, l - 1);
    }

    private int count(int[] arr, int limit) {

        int left = 0;
        int sum = 0;
        int ans = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > limit) {
                sum -= arr[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
