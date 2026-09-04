class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int max = nums[0];

            for (int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }

            int min = nums[i];

            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
            }

            if (max - min <= k) {
                return i;
            }
        }

        return -1;
    }
}
## Problem Explanation

You are given an integer array `nums` and an integer `k`.

For every index `i`, we need to calculate its **instability score**:

`max(nums[0...i]) - min(nums[i...n-1])`

Where:

- `max(nums[0...i])` is the maximum element from index `0` to `i`.
- `min(nums[i...n-1])` is the minimum element from index `i` to `n - 1`.

An index is called **stable** if its instability score is less than or equal to `k`.

We need to return the **smallest stable index**. If no index satisfies the condition, return `-1`.

### Brute Force Approach

For each index `i`:

1. Find the maximum value from index `0` to `i`.
2. Find the minimum value from index `i` to `n - 1`.
3. Calculate the instability score as `max - min`.
4. If the score is less than or equal to `k`, return `i`.
5. If no stable index is found, return `-1`.

### Example

For:

`nums = [5, 0, 1, 4]` and `k = 3`

At index `0`:

- Maximum in `[5]` = `5`
- Minimum in `[5, 0, 1, 4]` = `0`
- Instability score = `5 - 0 = 5`

Since `5 > 3`, index `0` is not stable.

At index `3`:

- Maximum in `[5, 0, 1, 4]` = `5`
- Minimum in `[4]` = `4`
- Instability score = `5 - 4 = 1`

Since `1 <= 3`, index `3` is stable.

Therefore, the answer is `3`.
