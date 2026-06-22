class Solution {
    public int minLights(int[] lights) {
        int n=lights.length;
        int[] diff=new int[n+1];
        for(int i=0; i<n;i++){
            if(lights[i]>0){
                int left=Math.max(0,i-lights[i]);
                int right=Math.min(n-1, i+lights[i]);
                diff[left]++;
                if(right+1<n)
                    diff[right+1]--;
            }
        }
        boolean[] visible=new boolean[n];
        int curr=0;
        for(int i=0; i<n; i++){
            curr+=diff[i];
            visible[i]=curr>0;
        }
        int ans=0;
        for(int i=0; i<n;){
            if(visible[i]){
                i++;
            }else{
                ans++;
                i+=3;
            }
        }
        return ans;
    }
}
