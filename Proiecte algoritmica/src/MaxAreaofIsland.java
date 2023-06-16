import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland {
    public static int Lee(int[][] a, int n, int m, int i, int j) {
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        a[i][j] = 2;
        int area = 1;
        while (!queue.isEmpty()) {
            int[] poz = queue.poll();
            for (int t = 0; t < 4; t++) {
                int iv = poz[0] + di[t];
                int jv = poz[1] + dj[t];
                if (iv >= 0 && iv < n && jv >= 0 && jv < m && a[iv][jv] == 1) {
                    a[iv][j] = 2;
                    area++;
                    queue.add(new int[]{iv, jv});
                }
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxx = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) {
                    int area = Lee(grid, grid.length, grid[0].length, i, j);
                    if (maxx < area)
                        maxx = area;
                }
        return maxx;
    }
}
