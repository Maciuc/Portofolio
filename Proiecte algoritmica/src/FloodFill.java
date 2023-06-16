public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;

        boolean[][] visited=new boolean[image.length][image[0].length];
        bkt(image,sr,sc,color,image[sr][sc],visited);
        return image;
    }
    public void bkt(int[][] image, int sr, int sc, int color, int oldColor, boolean[][] visited) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor || visited[sr][sc]) return;
        image[sr][sc]=color;
        visited[sr][sc]=true;
        bkt(image, sr - 1, sc, color,oldColor,visited);
        bkt(image, sr + 1, sc, color,oldColor,visited);
        bkt(image, sr, sc - 1, color,oldColor,visited);
        bkt(image, sr, sc + 1, color,oldColor,visited);
    }
}
