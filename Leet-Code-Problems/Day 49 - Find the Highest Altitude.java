class Solution {
    public int largestAltitude(int[] gain) {
        int altitude=0;
        int maxaltitude=0;
        int n=gain.length;
        for(int i=0; i<n; i++){
              altitude=altitude+gain[i];
              maxaltitude=Math.max(maxaltitude,altitude);
        }
        return maxaltitude;    
    }
}
