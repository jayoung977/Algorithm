import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[][] map;
	static int white;
	static int blue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		white = 0;
		blue = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		count(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
		

	}
	private static void count(int startR, int startC, int size) {
		if(allWhite(startR,startC,size)) {
			white++;
			return;
		}
		if(allBlue(startR,startC,size)) {
			blue++;
			return;
		}
		size = size/2;
		count(startR,startC,size);
		count(startR,startC+size,size);
		count(startR+size,startC,size);
		count(startR+size,startC+size,size);
		
		
	}
	private static boolean allBlue(int startR, int startC, int size) {
		for (int i = startR; i < startR+size; i++) {
			for (int j = startC; j < startC+size; j++) {
				if (map[i][j]==0) {//하얀색이 하나라도 있으면
					return false;
				}
			}
			
		}
		return true;
	}
	private static boolean allWhite(int startR, int startC, int size) {
		for (int i = startR; i < startR+size; i++) {
			for (int j = startC; j < startC+size; j++) {
				if (map[i][j]==1) {//파란색이 하나라도 있으면
					return false;
				}
			}
			
		}
		return true;
	}

}