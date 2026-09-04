class Solution {
    public int maxDiffSum(int[] arr) {
        int a = 0, b = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int x = Math.max(a + Math.abs(arr[i] - arr[i - 1]),
                             b + Math.abs(arr[i] - 1));
            
            int y = Math.max(a + Math.abs(1 - arr[i - 1]), b);
            
            a = x;
            b = y;
        }
        
        return Math.max(a, b);
    }
}
