
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N;
	static int[][] map;
	static long[][][] count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		count = new long[N][N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				// d: 0 가로, d: 1 세로, d: 2 대각선
				if (map[i][j] == 1)
					continue;
				// 가로
				count[i][j][0] = count[i][j - 1][0] + count[i][j - 1][2];

				if (i == 0)
					continue;
				// 세로
				count[i][j][1] = count[i - 1][j][1] + count[i - 1][j][2];
				if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
					continue;
				count[i][j][2] = count[i - 1][j - 1][0] + count[i - 1][j - 1][1] + count[i - 1][j - 1][2];

			}
		}
		System.out.println(count[N - 1][N - 1][0] + count[N - 1][N - 1][1] + count[N - 1][N - 1][2]);
	}
}
