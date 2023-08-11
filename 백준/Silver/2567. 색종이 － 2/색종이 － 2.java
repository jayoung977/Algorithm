

import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r =  Integer.parseInt(st.nextToken());
			int c =  Integer.parseInt(st.nextToken());
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					map[j][k] = 1;
				}
			}
			
		}
		for (int j = 1; j < 101; j++) {
			for (int k = 1; k < 101; k++) {
				if( map[j][k] != map[j][k-1] ) {
					answer++;
				}	
				if(  map[k][j] != map[k-1][j]) {
					answer++;
				}
			}
				
		}
		System.out.println(answer);

	}

}
