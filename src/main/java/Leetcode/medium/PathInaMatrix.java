package main.java.Leetcode.medium;

/**
 * Find if there exists a route between 2 points in a matrix
 * We can move only right and down
 * Apply BFS
 * Source is: 0
 * Destination is: 2
 * Routes traversable: 1
 * Routes non-traversable: -1
 */
public class PathInaMatrix {
    public static void main(String[] args) {
        int[][] route = {{-1, 1, 0, -1}, {-1, 1, 1, -1}, {-1, -1, 1, -1}, {-1, -1, -1, 2}};
        int sourcex, sourcey;

        boolean[][] isVisited = new boolean[route.length][route[0].length];
        boolean flag = false;

        for (int i = 0; i < route.length; i++) {
            for (int j = 0; j < route[0].length; j++) {
                if (route[i][j] == 0 && !isVisited[i][j]) {
                    sourcex = i;
                    sourcey = j;
                    if(isPath(route, sourcex, sourcey, isVisited)) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (flag)
            System.out.println("There is route between source and destintation");
        else
            System.out.println("There is no route between source and destintation");
    }

    static boolean isPath(int[][] route, int x, int y, boolean[][] isVisited) {
        if(isSafe(x, y, route) && route[x][y]!= -1 && !isVisited[x][y]) {
            isVisited[x][y] = true;

            if(route[x][y] == 2) {
                return true;
            }

            boolean up = isPath(route, x-1, y, isVisited);
            if(up) {
                return true;
            }

            boolean down = isPath(route, x+1, y, isVisited);
            if(down) {
                return true;
            }

            boolean right = isPath(route, x, y+1, isVisited);
            if(right) {
                return true;
            }

            boolean left = isPath(route, x, y-1, isVisited);
            if(left) {
                return true;
            }
        }
        return false;
    }

    static boolean isSafe(int row, int col, int[][] matrix) {
        if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            return true;
        }
        return false;
    }
}
