import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static int[][] map;
	static int cnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i< N; i++) {
			String s = br.readLine();
			char[] cs= s.toCharArray();
			for(int j=0; j< N; j++) {
				map[i][j] = cs[j]-'0';
			}
		}
		//확인용
//		for(int i=0; i< N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		//dfs
		cnt=0;
		for(int i=0; i< N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					cnt++;
					dfs(i,j,cnt+1);
				}
			}
		}
		System.out.println(cnt);
		//그룹 개수 출력
		int[] res = new int[cnt];
		for(int k=2; k< cnt+2; k++) {
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
		//확인용
//		for(int i=0; i< N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
	}
	static void dfs(int r, int c, int g) {
		map[r][c]=g;
		for(int d=0; d<4; d++) {
			int nr = r+dr[d]; 
			int nc = c+dc[d]; 
			if(!check(nr,nc)) continue;
			if(map[nr][nc]==1) {
				//map[nr][nc]=g;
				dfs(nr,nc,g);
			}
		}
//		System.out.printf("nr = %d, nc = %d",r,c);
//		System.out.println();
//		for(int i=0; i< N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("==========");
//		
	}
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
