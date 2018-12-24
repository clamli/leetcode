class Solution {
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        return go(maze, isVisited, start, destination);
    }
    
    
    private boolean go(int[][] maze, boolean[][] isVisited, int[] start, int[] destination) {
        if (isVisited[start[0]][start[1]]) return false;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        isVisited[start[0]][start[1]] = true;
        boolean flag;
        int next;
        // down
        flag = false;
        next = start[0];
        while ((next+1) < maze.length && maze[next+1][start[1]] == 0) next++;
        if (next != start[0]) flag = go(maze, isVisited, new int[]{next, start[1]}, destination);
        if (flag) return true;
        // up
        flag = false;
        next = start[0];
        while ((next-1) >= 0 && maze[next-1][start[1]] == 0) next--;
        if (next != start[0]) flag = go(maze, isVisited, new int[]{next, start[1]}, destination);
        if (flag) return true;
        // left
        flag = false;
        next = start[1];
        while ((next-1) >= 0 && maze[start[0]][next-1] == 0) next--;
        if (next != start[1]) flag = go(maze, isVisited, new int[]{start[0], next}, destination);
        if (flag) return true;
        // right
        flag = false;
        next = start[1];
        while ((next+1) < maze[0].length && maze[start[0]][next+1] == 0) next++;
        if (next != start[1]) flag = go(maze, isVisited, new int[]{start[0], next}, destination);
        if (flag) return true;
        return false;
    }
    
    
}