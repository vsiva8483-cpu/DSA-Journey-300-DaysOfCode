import java.util.*;

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int sx = knightPos[0] - 1, sy = knightPos[1] - 1;
        int tx = targetPos[0] - 1, ty = targetPos[1] - 1;

        if (sx == tx && sy == ty) return 0;

        int[][] moves = {
            {2,1},{2,-1},{-2,1},{-2,-1},
            {1,2},{1,-2},{-1,2},{-1,-2}
        };

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sx, sy, 0});
        vis[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] m : moves) {
                int x = cur[0] + m[0];
                int y = cur[1] + m[1];

                if (x >= 0 && x < n && y >= 0 && y < n && !vis[x][y]) {
                    if (x == tx && y == ty)
                        return cur[2] + 1;

                    vis[x][y] = true;
                    q.add(new int[]{x, y, cur[2] + 1});
                }
            }
        }

        return -1;
    }
}
