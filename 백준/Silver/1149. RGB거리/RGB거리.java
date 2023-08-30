
import java.util.*;
import java.io.*;

/*
 조건:
 1번 집부터 N번 집이 순서대로 있다.  N(2 ≤ N ≤ 1,000)
 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다
 i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
 모든 집을 칠하는 비용의 최솟값
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] D = new int[N+1][3];
		int [][] map = new int[N+1][3];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			D[1][i] = map[1][i];
			
		}
		//입력 끝
		for (int i = 2; i <=N; i++) {
			//R 시도
			D[i][0] = Math.min(D[i-1][1], D[i-1][2])+map[i][0];
			//G 시도
			D[i][1] = Math.min(D[i-1][0], D[i-1][2])+map[i][1];
			//B 시도
			D[i][2] = Math.min(D[i-1][0], D[i-1][1])+map[i][2];


			
		}
		System.out.println(Math.min(Math.min(D[N][0],D[N][1]),D[N][2]));

	}

}
