import java.util.Scanner;

public class Main {
	static int[][] dp;
	static int T,K,N;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			K = scann.nextInt();
			N = scann.nextInt();
			dp = new int[15][15];
			
			for (int i = 1; i < 15; i++) {
				dp[0][i] =i;
			}
			
			for (int i = 1; i <15 ; i++) {
				for (int j = 1; j < 15; j++) {
					for (int j2 = 1; j2 <= j; j2++) {
						dp[i][j] +=  dp[i-1][j2];
					}
					
				}
			}
			System.out.println(dp[K][N]);
		}
	}

}
