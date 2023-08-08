import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] originMap;
	static int lastCheeze;
	static int cnt;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lastCheeze = Integer.MAX_VALUE;
		cnt = 0;
 
		map = new int[M][N];
		originMap = new int[M][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer stt = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stt.nextToken());
				
			}
		}

		
		//입력 확인
//		for (int i = 0; i < M; i++) {
//		System.out.println(Arrays.toString(originMap[i]));
//	}

		
		while(!(checkAllzero())) {
			//1.원본배열 복사
			copyArr(originMap, map);
    		
			//2.바깥공기를 2로 바꾼다.
			air2two(0,0);
			
			//3.주변에 2있으면 3으로 바꾼다.
			convertThree();
			
			//4.3자리를 oriMap에서 0으로 바꾼다.
			convertZero();
			
			//5. map = originMap
			copyArr(map,originMap);
			cnt++;
			
		}
		System.out.println(cnt);
		System.out.println(lastCheeze);
		


		
		
		
	}


	static void copyArr(int[][] data1, int[][] data2) {
		for(int i=0;i<M;i++) {
			data1[i] = Arrays.copyOf(data2[i],N);
    		}		
	}


	static void convertZero() {
		int result = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==3) {
					originMap[i][j]=0;
					result++;
					
				}	
			}
		}
		lastCheeze = Math.min(lastCheeze, result);
		
	}


	static void convertThree() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					if(checkSurroundAir(i,j)) {
						map[i][j]=3;
					}
				}
			}
		}		
	}


	static boolean checkAllzero() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) { 
					return false;   // 하나라도 1이 있으면 (남은 치즈 있으면) false
				}
			}
		}
		return true;
	}


	static boolean checkSurroundAir(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!(check(nr,nc))) continue;
			if(map[nr][nc]==2) {
				return true;          //주변에 한개라도 2(바깥공기)이면 true
				}
			}
		return false;
	}





	static void air2two(int r, int c) {
		map[r][c]=2;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!(check(nr,nc))) continue;
			if(map[nr][nc]==0) {
				air2two(nr,nc);
			}
		}
		
	}
	static boolean check(int r, int c) {
		return r >=0 && r < M && c >=0 && c < N;
	}

}