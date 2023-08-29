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

			for (int i = 0; i < k; i++) {
				int sum = 0;
				int index = 1;
				for (int j = 1; j <= n; j++) {
					sum += map[i][j];
					map[i + 1][index++] = sum;
				}
			}
			sb.append(map[k][n] + "\n");
		}
		System.out.println(sb);
	}
}
