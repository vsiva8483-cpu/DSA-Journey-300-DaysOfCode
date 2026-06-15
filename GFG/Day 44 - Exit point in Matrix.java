class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n=mat.length;
        int m= mat[0].length;
        int i=0; int j=0;
        int dir=0;
        // code here
        while(i>=0 && i<n && j>=0 && j<m){
            if(mat[i][j]==1){
                mat[i][j]=0;
                dir=(dir+1)%4;
            }
            if(dir==0){
                j++;
            }else if(dir==1){
                i++;
            }
            else if(dir==2){
                j--;
            }else{
                i--;
            }
        }
        List<Integer> ans=new ArrayList<>();
        if(dir==0){
            j--;
        }else if(dir==1){
            i--;
        }else if(dir==2){
            j++;
        }else{
            i++;
        }
        ans.add(i);
        ans.add(j);
        return ans;
    }
}
