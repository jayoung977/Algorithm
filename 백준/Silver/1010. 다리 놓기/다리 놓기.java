
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M;
	static int[][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			D = new int[35][35];
			for (int i = 0; i < 35; i++) {
				Arrays.fill(D[i], 1);
			}

			for (int i = 2; i < 30; i++) {
				for (int j = 1; j < i; j++) {
					D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
				}
			}

			sb.append(D[M][N] + "\n");

		}
		System.out.println(sb);
	}

}
