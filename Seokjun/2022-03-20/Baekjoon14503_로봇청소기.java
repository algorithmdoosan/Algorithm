import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon14503_로봇청소기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // 상, 우, 하, 좌 (북, 동, 남, 서)
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int[][] room = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                room[i][j] = sc.nextInt();

        int cleanNum = 0;
        boolean canClean = true;
        while (canClean) {
            if (room[r][c] == 0) {
                room[r][c] = 9; // 9가 청소한 위치
                cleanNum++;
            }
            canClean = false;
            // 왼쪽 방향으로 총 4번 회전하며 청소할 위치 찾기
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                // System.out.printf("(%d, %d) %d\n", nr, nc, d);
                // 방을 벗어나지 않고 청소할 수 있는 위치라면 이동
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0) {
                    canClean = true;
                    r = nr;
                    c = nc;
                    break;
                }
            }
            // 청소할 공간이 없다면 후진
            if (!canClean) {
                int nd = (d + 2) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                // 방을 벗어나지 않고 벽이 아니라면 이동
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] != 1) {
                    canClean = true;
                    r = nr;
                    c = nc;
                }
            }
            // System.out.printf("(%d, %d) %d\n", r, c, d);
            // System.out.println("-----------------------");
        }

        // printArray(room);

        System.out.println(cleanNum);
    }

    public static void printArray(int[][] map) {
        for (int i = 0; i < map.length; i++)
            System.out.println(Arrays.toString(map[i]));
    }
}
