import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[][] map;
	static int count; //방법 총 개수 
	static int[] dr0 = {0,0,1}; // 인덱스 맞추려고 가운데 0 , 인덱스는  가로0, 세로 1, 대각 2 
	static int[] dc0 = {1,0,1};
	
	static int[] dr1 = {0,1,1};
	static int[] dc1 = {0,0,1};
	
	static int[] dr2 = {0,1,1};
	static int[] dc2 = {1,0,1};
	static boolean [][][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		init();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		dfs(0,1,0);
		System.out.println(count);
		
		
		
	}
	private static void dfs(int r, int c, int status) {
		//status 0:가로 1:세로,2:대각선
		visited[r][c][status] = true;
		
		if(r==N-1 && c==N-1) {
			count++;
			return;
		}
		int nr,nc;

		
		if(status==0) {
			for (int d = 0; d < dr0.length; d++) { //dr0.length로 하기 
				if(d==1) continue;
				nr = r+dr0[d];
				nc = c+dc0[d]; //첫좌표가 r,c라 체크 안해줘도됨
				if(!check(nr,nc)) continue;
				if(d==2 && !checkZero(nr,nc)) continue;
				if(map[nr][nc]==0&&!visited[nr][nc][d]&&d!=1) {
					visited[nr][nc][d] = true;
					dfs(nr,nc,d);
					visited[nr][nc][d] = false; //놓친부분.
				}
			}
			
		}else if(status==1) {
			for (int d = 0; d < dr1.length; d++) {
				if(d==0) continue;
				nr = r+dr1[d];
				nc = c+dc1[d]; //첫좌표가 r,c라 체크 안해줘도됨
				if(!check(nr,nc)) continue;
				if(d==2 && !checkZero(nr,nc)) continue;
				if(map[nr][nc]==0&&!visited[nr][nc][d]&&d!=0) {
					visited[nr][nc][d] = true;
					dfs(nr,nc,d);
					visited[nr][nc][d] = false;
				}
			}
			
		}else {
			for (int d = 0; d < dr2.length; d++) {
				nr = r+dr2[d];
				nc = c+dc2[d]; //첫좌표가 r,c라 체크 안해줘도됨
				if(!check(nr,nc)) continue;
				if(d==2 && !checkZero(nr,nc)) continue;
				if(map[nr][nc]==0&&!visited[nr][nc][d]) {
					visited[nr][nc][d] = true;
					dfs(nr,nc,d);
					visited[nr][nc][d] = false;
				}
			}
			
		}
		
	}
	private static boolean checkZero(int r, int c) { // 놓친조건.
		if(check(r-1,c)) {
			if(map[r-1][c]!=0) return false;
		}
		if(check(r,c-1)) {
			if(map[r][c-1]!=0) return false;
		}
		if(check(r,c)) {
			if(map[r][c]!=0) return false;
		}
		return true;
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
	private static void init() {
		map = new int[N][N];
		count = 0;
		visited = new boolean[N][N][3];
	}
}
