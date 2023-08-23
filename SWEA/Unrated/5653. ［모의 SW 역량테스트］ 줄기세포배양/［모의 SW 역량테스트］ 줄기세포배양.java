import java.util.*;
import java.io.*;

public class Solution{
	static class Cell{
		int r;
		int c;
		int life; //생명 수치.
		int resActiveTime; //활성까지 남은시간.
		int resDeathTime; //죽을때까지 남은시간.
		int state; // 현재상태  1: 활,0:비활 
		public Cell(int r, int c, int life, int resActiveTime, int resDeathTime, int state) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
			this.resActiveTime = resActiveTime;
			this.resDeathTime = resDeathTime;
			this.state = state;
		}
	}
	static int T;
	static int N,M,K;
	static int[][] map;
	static List<Cell> [] list;
	static final int S = 10;
	static int time, aliveCellNum;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N+2*K][M+2*K];
			list = new ArrayList[S+1];
			time = 0;
			aliveCellNum = 0;
			for (int i = 0; i < S+1; i++) {
				list[i] = new ArrayList<>();
				
			}
			for (int i = K; i < N+K; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = K; j < M+K; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
						list[map[i][j]].add(new Cell(i,j,map[i][j],map[i][j],map[i][j],0));
						aliveCellNum++;
					}
				}
			}//입력 끝
			
			while(true) {
				time++;
				changeState();
				if(time==K) {
					break;
				}
			}
			System.out.println("#"+t+" "+aliveCellNum);
			
			
		}

	}
	private static void changeState() {
		for (int i = S; i > 0 ; i--) { //생명주기가 큰 것부터 체크.
			int size = list[i].size();
			if(size>0) {
				for (int j = size-1; j >= 0; j--) { //죽으면 삭제하니까 뒤에서부터.
					//비활성 
					Cell cell = list[i].get(j);
					if(cell.state==0) {
						cell.resActiveTime--;
						if(cell.resActiveTime==0) {//활성상태되면.
							cell.state=1;
							continue;
						}
						continue;
					}
					//활성 
					if(cell.state==1) {
						spread(cell);
						cell.resDeathTime--;
						if(cell.resDeathTime==0) {//죽으면
							list[i].remove(j); //삭제.
							aliveCellNum--;
							continue;
						}
						continue;
						
					}
				}
			}
		}
		
	}
	private static void spread(Cell cell) {
		for (int d = 0; d < 4; d++) {
			int nr = cell.r+dr[d];
			int nc = cell.c+dc[d];
			if(map[nr][nc]==0) {
				map[nr][nc] = cell.life; //주의 
				list[cell.life].add(new Cell(nr,nc,cell.life,cell.life,cell.life,0));
				aliveCellNum++;
			}
			
		}
		
	}

}
