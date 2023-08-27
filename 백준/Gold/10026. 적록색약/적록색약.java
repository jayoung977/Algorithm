import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visitedN;
	static boolean[][] visitedA;
	static int abnormal,normal;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visitedN = new boolean[N][N];
		visitedA = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray(); 
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visitedN[i][j]) {
					normal++;
					dfsNormal(i,j,map[i][j]);
				}
				if(!visitedA[i][j]) {
					abnormal++;
					dfsAbnormal(i,j,map[i][j]);
				}
			}
			
		}

		System.out.println(normal+" "+abnormal);
		
		

	}
	private static void dfsAbnormal(int r, int c, char color) {
		visitedA[r][c]=true;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(color=='B') {
				if(map[nr][nc]==color && !visitedA[nr][nc]) {
					visitedA[nr][nc]=true;
					dfsAbnormal(nr,nc,color);
				}
			}else {
				if((map[nr][nc]=='R'||map[nr][nc]=='G') && !visitedA[nr][nc]) {
					visitedA[nr][nc]=true;
					dfsAbnormal(nr,nc,color);
				}
			}
		}
		
	}
	private static void dfsNormal(int r, int c, char color) {
		visitedN[r][c]=true;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if( map[nr][nc]==color && !visitedN[nr][nc]) {
				visitedN[nr][nc]=true;
				dfsNormal(nr,nc,color);
			}
			
		}
		
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
