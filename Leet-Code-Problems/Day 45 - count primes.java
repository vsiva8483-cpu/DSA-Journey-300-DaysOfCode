class Solution {
    public int countPrimes(int n) {
        boolean[] notprime = new boolean[n];
        int count=0;
       for(int i=2; i<n; i++){
        if(!notprime[i]){
            count++;
            for(int j=i+i; j<n; j +=i){
                notprime[j]=true;
            }
        }
       }
       return count;
       }
}
        
