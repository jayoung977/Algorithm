import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int group_n;
	static int[] groups = new int[25*25];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		group_n = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] cs = str.toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = cs[j]-'0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					group_n++;
					dfs(i,j);
				}
			}
		}
		System.out.println(group_n);
		Arrays.sort(groups);
		for(int g:groups) {
			if(g==0) continue;
			System.out.println(g);
		}
		

	}



	static void dfs(int r, int c) {
		visited[r][c]= true;
		groups[group_n]++;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) continue;
			if(map[nr][nc]==1 && !visited[nr][nc]) {
				dfs(nr,nc);
			}
		}
		
		
	}



	static boolean check(int r, int c) {
		return r >= 0 && c >=0 && r <N && c<N;
	}

}
