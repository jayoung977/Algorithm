import java.io.*;
import java.util.*;
public class Main {
	static int[][] dice = {{2},{4,1,3},{5},{6}};
	static int[][] map;
	static boolean[][] visited;
	static int N,M,K,answer, count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer=0;
		map= new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		move(0,0,0,0);//r,c,d,cnt
		System.out.println(answer);
		
//		System.out.println(Arrays.deepToString(dice));

	}
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0}; //0: 우, 1: 하, 2:좌, 3:상.
	static void move(int r, int c, int d, int cnt) {
		if(cnt==K) {
			return;
		}
//		System.out.println("r:"+(r+1)+", c:"+(c+1)+", d:"+d);
		int nr = r+dr[d];
		int nc = c+dc[d];
//		System.out.println("r:"+r+"c:"+c);
//		System.out.println("nr:"+(nr+1)+", nc:"+(nc+1));
		if(!(nr>=0 && nc>=0 && nr<N && nc<M)) { //범위 밖이면 후진 및 방향 바꿈.
			
			d=(d+2)%4;
			nr=r+dr[d];
			nc=c+dc[d];
//			System.out.println("d:"+d);
		}
		//주사위 배열 변환(이동방향대로 구른다.)
		int diceBelowNum = moveDice(d);
		count=1;
		visited=new boolean[N][M];
		dfs(nr,nc);
		answer+=map[nr][nc]*count;
		//diceBelowNum: 주사위의 아랫면에 있는 정수
		int nd;
		if(diceBelowNum>map[nr][nc]) nd = (d+1)%4;
		else if(diceBelowNum<map[nr][nc]) nd = d-1<0 ? 3:d-1;
		else nd=d;
		
//		System.out.println("cnt:"+cnt+":"+Arrays.deepToString(dice));
		move(nr,nc,nd,cnt+1);
		
		
	}
	static void dfs(int r, int c) {
		visited[r][c]=true;
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!(nr>=0 && nc>=0 && nr<N && nc<M)) continue;
			if(map[nr][nc]!=map[r][c])continue;
			if(visited[nr][nc])continue;
			visited[nr][nc]=true;
			count++;
			dfs(nr,nc);
		}
		

		
	}
	
	
	
	
	
	static int moveDice (int d) {
		if(d==0) { //0: 우
			int temp = dice[1][2];
			dice[1][2]=dice[1][1];
			dice[1][1]=dice[1][0];
			dice[1][0]=dice[3][0];
			dice[3][0]=temp;
		}
		else if(d==1) { //1: 하.
			int temp = dice[3][0];
			dice[3][0]=dice[2][0];
			dice[2][0]=dice[1][1];
			dice[1][1]=dice[0][0];
			dice[0][0]=temp;
			
		}
		else if(d==2) { //2: 좌.
			int temp = dice[1][0];
			dice[1][0]=dice[1][1];
			dice[1][1]=dice[1][2];
			dice[1][2]=dice[3][0];
			dice[3][0]=temp;
			
		}
		else  {  //3: 상.
			int temp = dice[0][0];
			dice[0][0]=dice[1][1];
			dice[1][1]=dice[2][0];
			dice[2][0]=dice[3][0];
			dice[3][0]=temp;
			
		}
		return dice[3][0];
	}

}