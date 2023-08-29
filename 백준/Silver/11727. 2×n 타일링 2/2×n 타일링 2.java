
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		D = new int[1001];
		Arrays.fill(D, -1);
		D[1] = 1;
		D[2] = 3;

		for (int i = 3; i <= N; i++) {
			D[i] = D[i - 1] + D[i - 2] * 2;
			D[i] %= 10007;
		}

		System.out.println(D[N]);
	}
}
