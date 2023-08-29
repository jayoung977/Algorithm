
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int T;
	static int k, n;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		int[][] map;

		for (int t = 1; t <= T; t++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			map = new int[15][15];

			for (int i = 0; i <= n; i++) {
				map[0][i] = i;
			}

			for (int i = 0; i <= k; i++) {
				map[i][1] = 1;
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
			sb.append(map[k][n] + "\n");
		}
		System.out.println(sb);
	}
}
