
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 0, 1, 0, -1, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { 1, 0, -1, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
	// static int[] dr = { 0, 1, 0, -1 };
	// static int[] dc = { 1, 0, -1, 0 };
	static int K, W, H;
	static int[][] map;
	static int[][][] dist;
	static boolean[][][] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 길이. 열의 수
		H = Integer.parseInt(st.nextToken()); // 세로 길이. 행의 수
		map = new int[H][W];
		dist = new int[H][W][K + 1];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// ==================입력 완료

		System.out.println(bfs());

	}

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 }); // 0,0에서 시작
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int k = cur[2];

				if (r == H - 1 && c == W - 1) {
					return cnt;
				}

				int size = 0; // 방향 배열 사용 크기
				// 말처럼 K번 이동했으면 상하좌우로만 이동 가능
				if (k < K) {
					size = 12;
				}
				// 말처럼 K번 이동 안 했으면 12개 방향 모두 가능
				else {
					size = 4;
				}
				for (int d = 0; d < size; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc)) {
						continue;
					}

					if (map[nr][nc] == 1) {
						continue;
					}

					if (d >= 4) {
						if (visited[nr][nc][k + 1]) {
							continue;
						}
						q.offer(new int[] { nr, nc, k + 1 });
						visited[nr][nc][k + 1] = true;
					}

					if (d < 4) {
						if (visited[nr][nc][k]) {
							continue;
						}
						q.offer(new int[] { nr, nc, k });
						visited[nr][nc][k] = true;
					}

				}

			}
			cnt++;
		}
		return -1;

	}

	static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
