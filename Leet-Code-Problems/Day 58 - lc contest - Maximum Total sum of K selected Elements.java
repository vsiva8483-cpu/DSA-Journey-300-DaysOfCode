class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long sum=0;
        int index=nums.length-1;
        while(k>0){
            long multiply=(long) nums[index]*mul;
            if(multiply>nums[index]){
                sum=sum+multiply;
            }else{
                sum=sum+nums[index];
            }
            mul--;
            index--;
            k--;
        }
        return sum;
    }
}
        
