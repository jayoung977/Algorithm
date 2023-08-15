import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char [N][2*N-1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				map[i][j]=' ';
			}
		}
		fillStar(0,N-1,N);
		printStar();
		
	

	}
	static void fillStar(int startR, int startC, int size) {
		if(size==3) {
			map[startR][startC]='*';
			map[startR+1][startC-1]=map[startR+1][startC+1]='*';
			map[startR+2][startC-2]=map[startR+2][startC-1]=map[startR+2][startC+1]=map[startR+2][startC]=map[startR+2][startC+2]='*';
			return;
		}
		size = size/2;
		fillStar(startR, startC, size);
		fillStar(startR+size, startC-size, size);
		fillStar(startR+size, startC+size, size);
		
	}
	static void printStar() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}

}
