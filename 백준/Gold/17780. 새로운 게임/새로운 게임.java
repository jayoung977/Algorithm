
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

	static class Chess {
		int d; // 방향
		int h; // 높이

		public Chess(int d, int h) {
			this.d = d;
			this.h = h;
		}
	}

	static int N, K;
	static int[][] map;
	static Deque<int[]>[][] dequeMap;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static List<int[]> chess;
	static int step;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		dequeMap = new ArrayDeque[N][N];
		chess = new ArrayList<>();
		chess.add(new int[] { -1, -1 });

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dequeMap[i][j] = new ArrayDeque<>();
			}

		}
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			dequeMap[r][c].offer(new int[] { i, d });
			chess.add(new int[] { r, c });
		}

		// -----------입력 완료

		while (true) {
			step++;

			if (step > 1000) {
				System.out.println(-1);
				return;
			}

			for (int a = 1; a <= K; a++) {
				int[] cur = chess.get(a);
				int r = cur[0];
				int c = cur[1];
			

				int num = dequeMap[r][c].peekFirst()[0];
				int d = dequeMap[r][c].peekFirst()[1] - 1;

				if (num != a) { // 말이 가장 아래에 위치하지 않은 경우
					continue;
				}

				int nr = r + dr[d]; // 이동하려는 좌표
				int nc = c + dc[d];

				// 이동하려는 칸이 파란색이거나 벽
				if (!check(nr, nc) || map[nr][nc] == 2) {
					// 방향 바꾸기
					int tmpD = dequeMap[r][c].peekFirst()[1];
					if (tmpD == 1) {
						tmpD = 2;
					}
					else if (tmpD == 2) {
						tmpD = 1;
					}
					else if (tmpD == 3) {
						tmpD = 4;
					}
					else if (tmpD == 4) {
						tmpD = 3;
					}
					dequeMap[r][c].peekFirst()[1] = tmpD;

					nr = r + dr[tmpD - 1]; // 이동하려는 좌표
					nc = c + dc[tmpD - 1];
				}

				// 이동하려는 칸이 흰색이면 이동
				if (check(nr, nc) && map[nr][nc] == 0) {
					int size = dequeMap[r][c].size();
					for (int i = 0; i < size; i++) {
						int[] e = dequeMap[r][c].poll();
						dequeMap[nr][nc].offer(e);
						chess.get(e[0])[0] = nr;
						chess.get(e[0])[1] = nc;
					}
					if (dequeMap[nr][nc].size() >= 4) {
						System.out.println(step);
						return;
					}
				}

				// 이동하려는 칸이 빨간색이면 이동
				if (check(nr, nc) && map[nr][nc] == 1) {
					int size = dequeMap[r][c].size();
					for (int i = 0; i < size; i++) {
						int[] e = dequeMap[r][c].pollLast();
						dequeMap[nr][nc].offer(e);
						chess.get(e[0])[0] = nr;
						chess.get(e[0])[1] = nc;
					}
					if (dequeMap[nr][nc].size() >= 4) {
						System.out.println(step);
						return;
					}
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}