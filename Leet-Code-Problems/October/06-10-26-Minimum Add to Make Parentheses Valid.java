import java.util.Stack;
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>stack=new Stack<>();
        int ans=0;
        for(char ch:s.toCharArray()){
        if(ch=='('){
            stack.push(ch);
        }
        else{
            if(!stack.isEmpty()){
                stack.pop();
            }
            else{
                ans++;
            }
        }
        }
        ans=ans+stack.size();
        return ans;
    }
}
