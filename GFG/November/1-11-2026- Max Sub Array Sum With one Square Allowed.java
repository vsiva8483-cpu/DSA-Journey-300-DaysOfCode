class Solution {
    public int maximumSubarray(int[] arr) {

        int withoutSquare = arr[0];
        int withSquare = arr[0] * arr[0];

        int ans = Math.max(withoutSquare, withSquare);

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            int newWithSquare = Math.max(
                withSquare + current,
                Math.max(withoutSquare + current * current,
                         current * current)
            );

            int newWithoutSquare = Math.max(
                withoutSquare + current,
                current
            );

            withSquare = newWithSquare;
            withoutSquare = newWithoutSquare;

            ans = Math.max(ans, Math.max(withoutSquare, withSquare));
        }

        return ans;
    }
}
