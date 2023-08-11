

import java.io.*;
import java.util.*;

public class Main {
	static int N,M,R;
	static int[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
//	static int value;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		int grop_value = Math.min(N, M) / 2;
		
		for(int i = 0 ; i < R; i ++) {
			for (int j = 0; j < grop_value; j++) {
				int value = map[j][j];
				int r = j;
				int c = j;
				int idx = 0;
				while(idx < 4) {
					int nr = r + dr[idx];
					int nc = c + dc[idx];
					
					if(check(j,nr,nc)) {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
					}
					else {
						idx++;
					}
				}
				
				map[j+1][j] = value;
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static boolean check(int j, int nr, int nc) {
		return nr >= j && nr <N-j && nc >=j && nc <M-j;
}

}