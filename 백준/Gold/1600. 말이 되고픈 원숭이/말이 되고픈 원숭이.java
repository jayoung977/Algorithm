
/*
 조건:
 말 (r-2,c-1),(r-1,c-2),(r+1,c-2),(r+2,c-1)
   (r-2,c+1),(r-1,c+2),(r+1,c+2),(r+2,c+1) 
 원숭이는 능력이 부족해서 총 K번만 위와 같이 움직일 수 있고, 그 외에는 그냥 인접한 칸으로만 움직일 수 있다.   
 대각선 방향은 인접한 칸에 포함되지 않는다.   
 원숭이의 동작수의 최솟값
 시작점에서 도착점까지 갈 수 없는 경우엔 -1
 첫째 줄에 정수 K
 둘째 줄에 격자판의 가로길이 W, 세로길이 H
 0은 아무것도 없는 평지, 1은 장애물. 장애물이 있는 곳으로는 이동할 수 없다
 W와 H는 1이상 200이하의 자연수이고, K는 0이상 30이하의 정수이다.
 2 초
 
 아이디어: BFS + 3차원 배열
 초기화 K+1?
 
 오답노트: 무조건 방문처리를 하면 안된다 특히 BFS!!!!!!!!!!!!!! (dfs는 지울 수 있어서 방문 처리 true - false가능 )
 */
import java.io.*;
import java.util.*;
public class Main {
	static int K;
	static int H,W;
	static int [][] map;
	static boolean [][][] visited;
	static Queue<int []> q;
	static int answer;
	static int[] dr = {-1,0,1,0,-2,-1,1,2,-2,-1,1,2};
	static int[] dc = {0,1,0,-1,-1,-2,-2,-1,1,2,2,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W= Integer.parseInt(st.nextToken()); //열 개수
		H = Integer.parseInt(st.nextToken());//행 개수
		init();
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//입력 끝
		if(H==1 && W==1) {
			if(map[0][0]==1) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		q.offer(new int [] {0,0,0,0});
		bfs();
		if(answer== Integer.MAX_VALUE/1000) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
	}
	private static void bfs() {

		while(true) {
			int size = q.size();
			if(size==0) {
				break;
			}
			
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];
				int k = cur[3];
				if(r==H-1&&c==W-1) {
					answer = Math.min(answer, cnt);
					return;
				}
				for (int d = 0; d < dr.length; d++) {
					int nr=r+dr[d];
					int nc=c+dc[d] ;
					
					
					if(!check(nr,nc)) continue;
					if( map[nr][nc]!=0)continue;
					if(d<=3  && !visited[nr][nc][k] ) {
						visited[nr][nc][k] = true;
						q.offer(new int[] {nr,nc,cnt+1,k});
					}
					else if(d>3 && k<K && !visited[nr][nc][k+1]) { //K
						visited[nr][nc][k+1] = true;
						q.offer(new int[] {nr,nc,cnt+1,k+1});
					
					}
				}
				
			}
			
		}
		
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<H && c<W;
	}
	private static void init() {
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		q = new LinkedList<>();
		answer = Integer.MAX_VALUE/1000;
	}

}
