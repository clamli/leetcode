class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] flag = new boolean[image.length][image[0].length];
        flood(image, sr, sc, newColor, image[sr][sc], flag);
        return image;
    }
    
    private void flood(int[][] image, int sr, int sc, int newColor, int preColor, boolean[][] flag) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || flag[sr][sc] || image[sr][sc] != preColor) {
            return;
        }
        image[sr][sc] = newColor;  
        flag[sr][sc] = true;
        flood(image, sr-1, sc, newColor, preColor, flag);
        flood(image, sr, sc-1, newColor, preColor, flag);
        flood(image, sr+1, sc, newColor, preColor, flag);
        flood(image, sr, sc+1, newColor, preColor, flag);
    }
}