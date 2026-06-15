class Solution {
    public boolean checkGoodInteger(int n) {
        int digitsum=0;
        int squaresum=0;
        while(n>0){
            int digit=n%10;
            digitsum+=digit;
            squaresum+=digit*digit;
            n/=10;
        }
        return squaresum-digitsum>=50;
    }
}
