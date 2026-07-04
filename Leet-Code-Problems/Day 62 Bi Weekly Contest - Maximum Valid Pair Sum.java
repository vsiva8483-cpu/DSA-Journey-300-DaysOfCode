class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n=nums.length;
        int Leftmax=nums[0];
        int ans=0;
        for(int j=k; j<n; j++){
            Leftmax=Math.max(Leftmax,nums[j-k]);
            ans=Math.max(ans,Leftmax+nums[j]);
        }
        return ans;
    }
}©leetcode
