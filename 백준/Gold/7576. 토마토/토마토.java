import java.io.*;
import java.util.*;
public class Main {
	static int N,M,answer;
	static int[][] map;
	static Queue<int[]> que;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		//세로 M
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    que = new LinkedList<int[]>();
	    answer = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					que.offer(new int[] {i,j,0});
				}
			}
		}
		bfs();
		if(!allOneCheck()) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	    

	private static void bfs() {
		while(!que.isEmpty()) {
			answer++;
			int size = que.size();
			while(size-->0) {
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(!check(nr,nc)) continue;
					if(map[nr][nc]==0) {
						map[nr][nc]=1;
						que.offer(new int[] {nr,nc,cnt+1});
					}
				}
						
			}
			
		}
		
		
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M ;
	}
	
	private static boolean allOneCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
			
		}
		return true;
		
	}
}
