import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] cs = str.toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = cs[j]-'0';
			}
			
		}

		for  (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					cnt++;
					dfs(i,j,cnt+1);
				}

				
			}
		}
		System.out.println(cnt);
		int[] res = new int[cnt];
		for (int k = 2; k < cnt+2; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==k) {
						res[k-2]++;
					}
				}
			}
			
		}
		Arrays.sort(res);
		for(int r:res) {
			System.out.println(r);
		}
		

		
	}
	static void dfs(int r, int c, int g) {
		map[r][c] = g;
		for (int j = 0; j < 4; j++) {
			int nr = r+dr[j];
			int nc = c+dc[j];
			if(!check(nr,nc)) continue;
			if(map[nr][nc]==1) {
				map[nr][nc]=g;
				dfs(nr,nc,g);
			}	
		}
		
	}
	static boolean check(int r, int c) {
		return r >= 0 && c >=0 && r <N && c<N;
	}

}
