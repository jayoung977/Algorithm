import java.io.*;
import java.util.*;
public class Main{
	static int C;
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		C = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		map = new int[C+1][C+1];
		visited  = new boolean[C+1];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r= Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
//		for (int i = 0; i < C+1; i++) {
//			System.out.println(Arrays.toString(map[i]));
//			
//		}
//		
		dfs(1);
		System.out.println(answer);
		 
	}
	private static void dfs(int r) {
		if(r!=1) {
			answer++;
		}
		for (int c = 1; c <= C; c++) {
			if(map[r][c]!=0 && !visited[c]) {
//				System.out.println("idx: "+r+" c: "+c);
				visited[c] = true;
				dfs(c);
				
			}
		}
		
	}

}
