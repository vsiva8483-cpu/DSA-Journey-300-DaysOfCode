class Solution {
    public boolean fourSum(int[] arr, int x) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int i=0;
        int j=i+1;
        int left=j+1;
        int right=n-1;
        int sum=0;
        while(left<right){
            sum=arr[i]+arr[j]+arr[left]+arr[right];
            if(sum==x){
                return true;
            }
            if(sum<x){
                left++;
            }
            if(sum>x){
                right--;
            }
        }
        return false;
    }
}
