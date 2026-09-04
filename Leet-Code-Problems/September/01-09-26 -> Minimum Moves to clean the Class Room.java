import java.util.*;

class Solution {
    public int minMoves(String[] a, int e) {
        int m=a.length,n=a[0].length(),sr=0,sc=0,k=0;
        int[][] id=new int[m][n];

        for(int i=0;i<m;i++) Arrays.fill(id[i],-1);

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(a[i].charAt(j)=='S'){sr=i;sc=j;}
                if(a[i].charAt(j)=='L') id[i][j]=k++;
            }

        int all=(1<<k)-1;
        boolean[][][][] v=new boolean[m][n][1<<k][e+1];
        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{sr,sc,0,e,0});
        v[sr][sc][0][e]=true;

        int[] dr={1,-1,0,0},dc={0,0,1,-1};

        while(!q.isEmpty()){
            int[] x=q.poll();
            int r=x[0],c=x[1],mask=x[2],en=x[3],d=x[4];

            if(mask==all) return d;
            if(en==0) continue;

            for(int z=0;z<4;z++){
                int nr=r+dr[z],nc=c+dc[z];
                if(nr<0||nr>=m||nc<0||nc>=n||a[nr].charAt(nc)=='X') continue;

                int nm=mask,ne=en-1;
                if(a[nr].charAt(nc)=='L') nm|=1<<id[nr][nc];
                if(a[nr].charAt(nc)=='R') ne=e;

                if(!v[nr][nc][nm][ne]){
                    v[nr][nc][nm][ne]=true;
                    q.add(new int[]{nr,nc,nm,ne,d+1});
                }
            }
        }
        return -1;
    }
}
