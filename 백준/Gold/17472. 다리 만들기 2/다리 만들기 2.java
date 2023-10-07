import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//1. 섬에 번호 붙이기
		int num = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0 || visit[i][j]) continue;
				dfs(i, j, num);
				num++;
			}
		}
		
		//2. dist 배열 만들기
		int[][] dist = new int[num][num];
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) dist[i][j] = 100;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) continue;
				int cur = map[i][j];
				
				for(int k=0;k<4;k++) {
					int nr = i + d[0][k];
					int nc = j + d[1][k];
					
					int cnt = 0;
					while(inMap(nr, nc) && map[nr][nc]==0) {
						nr += d[0][k];
						nc += d[1][k];
						cnt ++;
					}
					
					if(cnt<2) cnt = 100;
					if(inMap(nr, nc) && map[nr][nc]!=0 && map[nr][nc]!= cur) {
						dist[cur][map[nr][nc]] = Math.min(cnt, dist[cur][map[nr][nc]]);
					}
				}
			}
		}
		
		//3. 프림 알고리즘
		int answer = 0;
		boolean[] include = new boolean[num];
		int cnt = 0;
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(
				(Integer[] a, Integer[] b) -> a[1]-b[1]
				);
		pq.add(new Integer[] {1, 0});
		
		while(!pq.isEmpty()) {
			Integer[] edge = pq.poll();
			int cur = edge[0];
			if(include[cur]) continue;
			
			include[cur] = true;
			answer += edge[1];
			cnt++;
			
			for(int i=1;i<num;i++) {
				if(!include[i] && i!=cur && dist[cur][i]!=100) {
					pq.add(new Integer[] {i, dist[cur][i]});
				}
			}
		}
		
		if(cnt==num-1) System.out.println(answer);
		else System.out.println(-1);

	}
	
	public static void dfs(int row, int col, int num) {
		visit[row][col] = true;
		map[row][col] = num;
		
		for(int i=0;i<4;i++) {
			int nr = row + d[0][i];
			int nc = col + d[1][i];
			
			if(inMap(nr, nc) && !visit[nr][nc] && map[nr][nc]==1) {
				dfs(nr, nc, num);
			}
		}
	}
	
	public static boolean inMap(int row, int col) {
		if(0<=row && row<N && 0<=col && col<M) return true;
		else return false;
	}

}