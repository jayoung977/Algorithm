import java.io.*;
import java.util.*;
/*
 아이디어: bfs,비트 연산,visited 3차원 배열(64)
 */
public class Main {
    static class Cell{
        int r;
		int c;
        int cnt;
        int flag;
        public Cell(int r, int c, int cnt, int flag) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.flag = flag;
        }
    }
    static int N,M;
    static char[][] map;
    static boolean[][][] visited;
    static Queue<Cell> q;
    static int answer;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();
        for (int i = 0; i < N; i++) {
            char tmp[] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp[j];
                if(map[i][j]=='0') { //시작점
                    q.offer(new Cell(i,j,0,0));
                }
            }
        }

    bfs();
    if(answer == Integer.MAX_VALUE/1000) {
        answer =-1;
    }
    System.out.println(answer);
	}
	private static void bfs() {
	    while(!q.isEmpty()) {
	        int size = q.size();
	        while(size-->0) {
	        	Cell cur = q.poll(); //주
	        	int r = cur.r;
	        	int c = cur.c;
	        	int cnt = cur.cnt;
	        	int flag = cur.flag;
	        	visited[r][c][0] = true;
	            for (int d = 0; d < 4; d++) {
	                int nr= r+dr[d];
	                int nc= c+dc[d];
	                if(!check(nr,nc)) continue;
	                if(map[nr][nc]=='#') continue;
	                if(map[nr][nc]=='1') { //도착했을 때.
	                	answer = Math.min(answer, cnt+1);
	                	continue;
	                }
	                if(!visited[nr][nc][flag]) {
	                	if(map[nr][nc]=='.' || map[nr][nc]=='0' ) {//주의 :0도갈 수 있음!!!//열쇠획득X
	                    	visited[nr][nc][flag] = true;
	                    	q.offer(new Cell(nr,nc,cnt+1,flag));
	                	}else if(Character.isLowerCase(map[nr][nc])) {
	                		lowerUpdate(nr,nc,cnt,flag, map[nr][nc]);
	                	}else if(Character.isUpperCase(map[nr][nc])) {
	                		upperUpdate(nr,nc,cnt,flag, map[nr][nc]);
	                	}
	                	
	                }
	                
	            }	
	        }
	    }
	}
	private static boolean check(int nr, int nc) {
		return nr>=0 && nc>=0 && nr<N && nc<M;
	}
	private static void upperUpdate(int nr, int nc, int cnt, int flag, char c) {
		int cidx = c-'A';
		if((flag & (1<<cidx)) !=0) { //키있으면.
			visited[nr][nc][flag] = true;
			q.offer(new Cell(nr,nc,cnt+1,flag)); //열쇠는 여러번 사용 가능.
			return;
		}
	}
	private static void lowerUpdate(int nr, int nc,int cnt, int flag,  char c) {
		int cidx = c-'a';
		visited[nr][nc][flag | (1<<cidx)] = true; //flag 변경.
		q.offer(new Cell(nr,nc,cnt+1,flag | (1<<cidx)));  //cnt 및 flag 변경.
	}
	private static void init() {
	    map = new char[N][M];
	    visited = new boolean[N][M][(int) Math.pow(2, 6)];
	    q = new LinkedList<>();
	    answer = Integer.MAX_VALUE/1000;
	}


}