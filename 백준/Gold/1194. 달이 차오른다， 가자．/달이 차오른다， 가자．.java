
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] map;
	static int posR, posC; // 민식이 현재 위치
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean visited[][][];
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					posR = i;
					posC = j;
				}
			}
		}
		// ============입력 완료

		System.out.println(bfs());

	}

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { posR, posC, 0 });
		visited[posR][posC][0] = true;
		map[posR][posC] = '.';

		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int key = cur[2];
				// System.out.println(r+" "+c);

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc)) {
						continue;
					}

					if (map[nr][nc] == '1') {
						return cnt + 1;
					}

					if (visited[nr][nc][key]) {
						continue;
					}
					if (map[nr][nc] == '#') {
						continue;
					}

					// 키를 만난 경우
					else if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
						// 키 추가 (flag 변경)
						int key2 = key | (1 << (map[nr][nc] - 'a'));
						q.offer(new int[] { nr, nc, key2 });
						visited[nr][nc][key2] = true;
					}

					// 문을 만난 경우
					else if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
						// 키가 있으면 이동
						int count = map[nr][nc] - 'A';
						if ((key & (1 << count)) != 0) {
							q.offer(new int[] { nr, nc, key });
							visited[nr][nc][key] = true;
						} else {
							// 키가 없으면 이동 못 함
							continue;
						}
					} else {
						q.offer(new int[] { nr, nc, key });
						visited[nr][nc][key] = true;
					}

				}
			}
			cnt++;
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
