import java.io.*;
import java.util.*;
public class Main {
	static int R,C;
	static char map[][];
	static int[] dr={-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static int initSr,initSc,initWr,initWc;
	static Queue<int[]> Sq,Wq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Sq = new LinkedList<int[]>();
		Wq = new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			char[] res = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = res[j];
				if(map[i][j]=='S') {
					initSr = i;
					initSc = j;
					Sq.offer(new int[] {i,j,0});
				}else  if(map[i][j]=='*') {
					initWr = i;
					initWc = j;
					Wq.offer(new int[] {i,j});
				}
				
			}
		}
		
		while(true) {
			if(Sq.size()==0) {
				System.out.println("KAKTUS");
				break;
			}
			bfsW();
			int ans = bfsS();
			if(ans > 0) {
				System.out.println(ans);
				break;
			}
			
		}
		
	

	}

	private static void bfsW() {
		int size = Wq.size();
		while(size-->0) {
			int[] cur = Wq.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r +dr[d];
				int nc = c +dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc]=='.' ||map[nr][nc]=='S') {
					map[nr][nc]='*';
					Wq.offer(new int[] {nr,nc});
				}
				
			}
		}
		
	}

	private static int bfsS() {
		int size = Sq.size();
		while(size-->0) {
			int[] cur = Sq.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			for (int d = 0; d < 4; d++) {
				int nr = r +dr[d];
				int nc = c +dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc]=='D') {
					return cnt+1;
				}
				if(map[nr][nc]=='.') {
					map[nr][nc]='S';
					Sq.offer(new int[] {nr,nc,cnt+1});
				}
				
			}
		}
		
		return -1;
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}

}
