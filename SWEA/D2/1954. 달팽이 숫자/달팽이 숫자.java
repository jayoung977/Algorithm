import java.io.*;
import java.util.*;
public class Solution{
	static int T,N;
	static int[][] map;
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static Queue<int[]> que;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			que = new LinkedList<int[]>();
			que.offer(new int[] {0,0,1});
			map[0][0]=1;
			int idx = 0;
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				if(cnt == N*N) {
					break;
					}
				int nr = r+dr[idx%4];
				int nc = c+dc[idx%4];
 
				if(!check(nr,nc) || map[nr][nc]!=0) {
					idx++;
					nr = r+dr[idx%4];
					nc = c+dc[idx%4];
					
				}
				que.offer(new int[] {nr,nc,cnt+1});
				map[nr][nc]=cnt+1;
				
				
			}
            System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}


	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}

}
