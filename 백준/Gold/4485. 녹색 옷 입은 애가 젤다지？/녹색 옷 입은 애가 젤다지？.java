import java.util.*;
import java.io.*;
public class Main {	
	static int N;
	static int[][] map;
//	static int[][] visited;
	static int answer;
	static int testcase = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0) break;
			testcase++;
			map=new int[N][N];
			int[][] visited=new int[N][N];
			answer=Integer.MAX_VALUE/1000;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					visited[i][j]=Integer.MAX_VALUE;
				}
			}
			visited[0][0] = map[0][0];
			dfs(0,0,visited,map[0][0]);
			System.out.println("Problem " + testcase + ": " +answer);
			
		}

	}
	static int[] dr={0,1,0,-1};
	static int[] dc={1,0,-1,0};
	static void dfs(int r, int c, int[][] visited, int tot) {
		if(tot>=answer) return;
		
		if(r==N-1&&c==N-1) {
//			System.out.println("tot:"+tot);
			answer = Math.min(tot, answer);
			return;
		}
		for(int d=0; d<4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!(nr>=0 && nc>=0 && nr<N && nc<N)) continue;
			if(visited[nr][nc]<=tot+map[nr][nc]) continue;
	        
			visited[nr][nc] = tot+map[nr][nc];
			dfs(nr,nc,visited,tot+map[nr][nc]);
	
		}
		
	}

}

/*
3
5 5 4
3 9 1
3 2 7
0 
 */