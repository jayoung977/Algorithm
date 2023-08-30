
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cost = new int[N + 1][3];
		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] D = new int[N + 1][3]; // 금액 n에 대한 최소 동전 수
		// 점화식으로 채워질 수 없는 동적테이블의 값 초기화!
		D[0][0] = 0;
		D[0][1] = 0;
		D[0][2] = 0;

		for (int i = 1; i <= N; i++) {
			D[i][0] = Math.min(D[i - 1][1] + cost[i][1], D[i - 1][2] + cost[i][2]);
			D[i][1] = Math.min(D[i - 1][0] + cost[i][0], D[i - 1][2] + cost[i][2]);
			D[i][2] = Math.min(D[i - 1][0] + cost[i][0], D[i - 1][1] + cost[i][1]);
		}

		int answer = Math.min(Math.min(D[N][0], D[N][1]), D[N][2]);

		System.out.println(answer);

	}
}
