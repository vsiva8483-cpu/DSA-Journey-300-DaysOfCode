class Solution {
    public int getLastDigit(String a, String b) {
        // code here
        if(b.equals("0"))
        return 1;
        int base = a.charAt(a.length()-1)-'0';
        int exp=0;
        for(int i=0; i<b.length(); i++){
            exp=(exp*10+(b.charAt(i)-'0'))%4;
        }
        if(exp==0)
        exp=4;
        int result=1;
        for(int i=0; i<exp; i++){
            result=(result*base)%10;
        }
        return result;
        
    }
};
