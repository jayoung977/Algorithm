import java.io.*;
import java.util.*;
public class Main {
	static final int N = 19;
	static int [][] map = new int[N+2][N+2];
	static int[] dr = {-1,0,-1,1};
	static int[] dc = {-1,-1,0,-1};
	
    static int[] dr1 = {1,2,3,4,5};
    static int[] dc1 = {1,2,3,4,5};
    static int[] dr2 = {0,0,0,0,0};
    static int[] dc2 = {1,2,3,4,5};
    static int[] dr3 = {1,2,3,4,5}; 
    static int[] dc3 = {0,0,0,0,0};
    static int[] dr4 = {-1,-2,-3,-4,-5}; 
    static int[] dc4 = {1,2,3,4,5};
    static int whoWin = 0;
    static int winr = 0;
    static int winc = 0;
    static Queue<int[]> que;
    static int cnt1,cnt2,cnt3,cnt4;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		que = new LinkedList<int[]>();
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					que.offer(new int[] {i,j});
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			if(winCheck(cur[0], cur[1])) {
				whoWin= map[cur[0]][cur[1]];
				winr = cur[0];
				winc = cur[1];
			}
		}
		if(whoWin==0) {
			System.out.println(0);
			return;
		}
		System.out.println(whoWin);
		System.out.println(winr+" "+winc);
		
		
	}

	private static boolean winCheck(int r, int c) {
		int who = map[r][c];
		cnt1 = 1;
		cnt2 = 1;
		cnt3 = 1;
		cnt4 = 1;
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d]; 
			int nc=c+dc[d]; 
			if(!check(nr,nc)) continue;
			if(map[nr][nc]==who)continue;
			if(d==0) { if(check1(r,c,who)) return true;}
			else if(d==1) { if(check2(r,c,who)) return true;}
			else if (d==2){if(check3(r,c,who)) return true;}
			else {if(check4(r,c,who)) return true;}
		}
		return false;

		
	}





	private static boolean check1(int r, int c,int who) {
		for (int d = 0; d < 5; d++) {
			int nr=r+dr1[d]; 
			int nc=c+dc1[d]; 
			if(!check(nr,nc)) break;
			if(map[nr][nc]!=who) break;
			else if(map[nr][nc]==who) {
				cnt1++;
			}	
		}
		if(cnt1==5) {
			return true;
		}
		return false;
	}

	private static boolean check2(int r, int c, int who) {
		for (int d = 0; d < 5; d++) {
			int nr=r+dr2[d]; 
			int nc=c+dc2[d]; 
			if(!check(nr,nc)) break;
			if(map[nr][nc]!=who) break;
			else if(map[nr][nc]==who) {
				cnt2++;
			}	
		}
		if(cnt2==5) {
			return true;
		}
		return false;
	}
	
	private static boolean check3(int r, int c, int who) {
		for (int d = 0; d < 5; d++) {
			int nr=r+dr3[d]; 
			int nc=c+dc3[d]; 
			if(!check(nr,nc)) break;
			if(map[nr][nc]!=who) break;
			else if(map[nr][nc]==who) {
				cnt3++;
			}	
		}
		if(cnt3==5) {
			return true;
		}
		return false;
	}
	private static boolean check4(int r, int c, int who) {
		for (int d = 0; d < 5; d++) {
			int nr=r+dr4[d]; 
			int nc=c+dc4[d]; 
			if(!check(nr,nc)) break;
			if(map[nr][nc]!=who) break;
			else if(map[nr][nc]==who) {
				cnt4++;
			}	
		}
		if(cnt4==5) {
			return true;
		}
		return false;
	}
	
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N+2 && c<N+2 ;
	}

}
