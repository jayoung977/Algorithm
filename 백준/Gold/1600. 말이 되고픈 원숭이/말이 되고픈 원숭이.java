import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 0, 1, 0, -1, -1, -2, -2, -1, 1, 2, 2, 1 }; //행 이동. 인덱스 0~3 : 한 칸 이동, 인덱스 4~11 : 말처럼 이동
	static int[] dc = { 1, 0, -1, 0, -2, -1, 1, 2, 2, 1, -1, -2 }; //열 이동. 인덱스 0~3 : 한 칸 이동, 인덱스 4~11 : 말처럼 이동
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine()); //K번 말처럼 이동할 수 있음
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로 길이. 열의 수
		H = Integer.parseInt(st.nextToken()); // 세로 길이. 행의 수
		map = new int[H][W]; //격자판
		visited = new boolean[H][W][K + 1]; //방문 체크

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ==================입력 완료

		System.out.println(bfs());

	}

	//시작지점에서 도착지점까지의 거리를 리턴하는 함수
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 }); // 0,0에서 시작(말처럼 0번 이동 상태)
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int k = cur[2];

				if (r == H - 1 && c == W - 1) { //도착지점에 도착하면
					return cnt; //너비 리턴
				}

				int size = 0; // 방향 배열 사용 크기 (인덱스0~3만 쓸 것인지, 12개 모두 쓸 것인지)
				// 말처럼 K번 이동 안 했으면 12개 방향 모두 가능
				if (k < K) {
					size = 12;
				}
				// 말처럼 K번 이동했으면 상하좌우로만 이동 가능
				else {
					size = 4;
				}
				for (int d = 0; d < size; d++) { //저장한 사용 크기만큼만 for문을 돌림
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!check(nr, nc)) { //범위를 벗어난 경우
						continue;
					}
					if (map[nr][nc] == 1) { //벽을 만난 경우
						continue;
					}
					if (d >= 4) { //말처럼 이동하는 경우
						if (visited[nr][nc][k + 1]) {
							continue;
						}
						q.offer(new int[] { nr, nc, k + 1 }); //말처럼 이동하므로 k+1
						visited[nr][nc][k + 1] = true; //방문 처리
					}
					if (d < 4) { //말처럼 이동하지 않고 그냥 이동하는 경우
						if (visited[nr][nc][k]) {
							continue;
						}
						q.offer(new int[] { nr, nc, k }); //그냥 이동하므로 k 유지
						visited[nr][nc][k] = true; //방문 처리
					}
				}
			}
			cnt++; //qsize만큼 돌고 나면 너비가 증가함
		}
		return -1; //q가 빌 때까지 도착지점에 다다르지 못한 경우 -1 리턴
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
