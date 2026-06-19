class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        // code here
        int n=arr.length;
        long[] pre =new long[n+1];
        for(int i=0; i<n; i++){
            pre[i+1]=pre[i]+arr[i];
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0; i<n; i++){
            int mid=i/2;
            long median=arr[mid];
            long leftsum=pre[mid+1];
            long leftcost=median * (mid+1L)-leftsum;
            long rightsum=pre[i+1]-pre[mid+1];
            long rightcost=rightsum-median*(i-mid);
            ans.add((int)(leftcost+rightcost));
        }
        return ans;
    }
    
}
