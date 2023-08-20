import java.io.*;
import java.util.*;
public class Main {
	static int T,N,M,K;
	static int[][] map;
	static int[] dr = {-1,0,1,0}; 
	static int[] dc = {0,-1,0,1}; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c]=1;
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}

	}
	private static void dfs(int r, int c) {
		map[r][c] = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc]==1) {
				dfs(nr,nc);
			}
			
		}
		
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}

}
