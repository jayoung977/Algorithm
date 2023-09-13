import java.util.*;
import java.io.*;
public class Solution{
	static int[][] pipedr = {
			{0,1,0,-1},{-1,1},{0,0},{-1,0},{1,0},{0,1},{0,-1}
	};
	static int[][] pipedc = {
			{1,0,-1,0},{0,0},{-1,1},{0,1},{0,1},{-1,0},{-1,0}
	};

	static boolean[][] visited;
	static int[][] map;
	static int T,N,M,R,C,L;
	static int answer;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N =  Integer.parseInt(st.nextToken());
			M =  Integer.parseInt(st.nextToken());
			R =  Integer.parseInt(st.nextToken());
			C =  Integer.parseInt(st.nextToken());
			L =  Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			answer = 0;
			q = new LinkedList<>();
			q.offer(new int[] {R,C});
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			bfs();
			
			System.out.println("#"+t+" "+answer);
		}
		
		

	}
	private static void bfs() {
		int time = 0;
		
		while(!q.isEmpty()) {
			
			if(time==L) return;
			int size = q.size();
			while(size-->0) {
				int [] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int pipenum = map[r][c]-1;
				visited[r][c]=true;
				answer++;
				for(int d=0; d<pipedr[pipenum].length;d++) {
					int nr = r + pipedr[pipenum][d];
					int nc = c + pipedc[pipenum][d];
					if(!check(nr,nc)) continue;
					if(map[nr][nc]==0) continue;
					if(!isConnect(r,c,nr,nc))continue;
					if(visited[nr][nc])continue;
					q.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
				}
			} time++;
			
			
		}
		
		
	}
	private static boolean isConnect(int r, int c, int nr, int nc) {
		int pipenum = map[nr][nc]-1;
		for(int d=0; d<pipedr[pipenum].length; d++) {
			int nnr = nr + pipedr[pipenum][d];
			int nnc = nc + pipedc[pipenum][d];
			if(nnr==r && nnc==c) return true;
			
		}
		return false;
	}
	private static boolean check(int r, int c) {
		return r>=0 && c >=0 && r <N && c <M;
	}

}
