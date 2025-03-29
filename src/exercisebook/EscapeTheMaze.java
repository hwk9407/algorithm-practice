package exercisebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 연습문제: 탈출구 찾기
 * N x M 크기의 미로가 있다.
 * 1은 이동 가능한 길, 0은 이동 불가능한 벽
 * 시작 위치는 (0, 0). 탈출구는 (N-1, N-1)
 * 이동은 상하좌우로만 가능하고 벽(0)을 통과할 수 없다.
 * 탈출구까지 도달하는 최단 거리를 구하라. (도달할 수 없다면 -1을 반환)
 */
public class EscapeTheMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        EscapeTheMaze theMaze = new EscapeTheMaze();
        int result = theMaze.bfs(maze);
        System.out.println("result = " + result);
    }

    private int bfs(int[][] maze) {
        Queue<int[]> queue = new LinkedList<>();
        int n = maze.length, m = maze[0].length, distance = 1;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[0][0] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.add(new int[]{0, 0, distance});

        while (!queue.isEmpty()) {
            int[] currentInfo = queue.poll();
            if (currentInfo[0] == n - 1 && currentInfo[1] == m - 1) return currentInfo[2];

            for (int d = 0; d < 4; d++) {
                int x = currentInfo[0] + dx[d], y = currentInfo[1] + dy[d];

                if (isMoveable(x, y, maze, visited)) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, currentInfo[2] + 1});
                }
            }
        }

        return -1;
    }

    private boolean isMoveable(int x, int y, int[][] maze, boolean[][] visited) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1 && !visited[x][y];
    }
}
