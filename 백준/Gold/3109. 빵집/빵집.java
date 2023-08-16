import java.io.*;
import java.util.*;
public class Main {
	static int R,C;
	static char [][] map;
	static boolean [][] visited;
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	static int answer = 0;
	static boolean isfinished;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean [R][C];
		answer = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i]=  str.toCharArray();
		
		}
		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
				if(!visited[i][0]&&map[i][0]=='.') {
					isfinished = false;
					dfs(i,0);
				}
			}
//		}
		System.out.println(answer);
		

	}
	private static void dfs(int r, int c) {
//		System.out.println("r: "+r +" c: "+c);
		
		visited[r][c] = true;
		if(c==C-1) {
			answer++;
			isfinished = true;
//			System.out.println("===================");
			
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) continue;
			if(!visited[nr][nc] && map[nr][nc]=='.') {
				dfs(nr,nc);
//				System.out.println("nr: "+nr +" nc: "+nc);
//				System.out.println(isfinished);
				if(isfinished) break;
				dfs(nr,nc);
//				else{dfs(nr,nc);}
				
			}
		}
	}
	private static boolean check(int r, int c) {
		
		return r>=0 && c >=0 && r < R && c < C;
	}

}
