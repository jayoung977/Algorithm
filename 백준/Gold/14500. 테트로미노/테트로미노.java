import java.util.*;
import java.io.*;
public class Main{
	static int[][] dr = {
			{0,0,0,0},
			{0,1,2,3},
			{0,0,1,1}, 
			{0,1,2,2}, 
			{2,0,1,2}, 
			{0,1,2,0},
			{0,0,1,2},
			{0,0,0,1},
			{0,1,0,0},
			{0,1,1,1},
			{1,1,0,1},
			{0,1,1,2},
			{1,2,0,1},
			{1,0,1,0},
			{0,0,1,1},
			{0,0,1,0},
			{1,0,1,1},
			{0,1,1,2},
			{1,0,1,2}			
	};
	static int[][] dc = {			
			{0,1,2,3},
			{0,0,0,0},	
			{0,1,0,1},
			{0,0,0,1},
			{0,1,1,1},
			{0,0,0,1},
			{0,1,1,1},
			{0,1,2,2},
			{0,0,1,2},
			{0,0,1,2},
			{0,1,2,2},
			{0,0,1,1},
			{0,0,1,1},
			{0,1,1,2},
			{0,1,1,2},
			{0,1,1,2},
			{0,1,1,2},
			{0,0,1,0},
			{0,1,1,1},
	};
	static int[][] map;
	static int N,M; //r,c
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = 0;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int n=0; n<dr.length;n++) {
			for(int i=0; i<N;i++) {
				for(int j=0; j < M; j++) {
					cal(i,j,n);
				}
			}
			
		}
		

		System.out.println(answer);


	}
	private static void cal(int r, int c, int n) {
		int sum = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[n][d];
			int nc = c+dc[n][d];
			if(!check(nr,nc)) return;
			sum+=map[nr][nc];
		}
		answer = Math.max(answer, sum);
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}

}
