

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
		map = new int[100][100];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c =  Integer.parseInt(st.nextToken());
			int r =  Integer.parseInt(st.nextToken());
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					map[j][k] = 1;
				}
			}
			
		}
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if(map[j][k] == 1) {
					answer++;
				}	
			}
				
		}
		System.out.println(answer);

	}

}