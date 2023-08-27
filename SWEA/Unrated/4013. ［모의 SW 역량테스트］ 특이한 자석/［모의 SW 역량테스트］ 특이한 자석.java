import java.io.*;
import java.util.*;
public class Solution {
	static final int W = 8;
	static final int D = 4;
	static int[][] map;
	static int [][] copyMap; //처음에 맵을 디큐로 만들려다가 시간 잡아먹음 걍 어레이 복사해서 풀
	static int T,N;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			map = new int[D][W];
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}

			
			for (int i = 0; i < N; i++) {
				visited = new boolean[4]; //돌때마다 visited 갱신해야함 
				st = new StringTokenizer(br.readLine());
				copyMap = new int [D][W];
				copyArr(map,copyMap);
				int nth = Integer.parseInt(st.nextToken())-1;
				int direct = Integer.parseInt(st.nextToken()); //여기 -1해서 또 틀
				move(nth,direct);
			}
			int sum = 0;
			
			sum += (map[0][0]==1?1:0);
			sum += (map[1][0]==1?2:0);
			sum += (map[2][0]==1?4:0);
			sum += (map[3][0]==1?8:0);
			
			System.out.println("#"+t+" "+sum);
			
		}
		
		

	}
	private static void move(int nth, int direct) {
		visited[nth]=true; //여기서 방문처리 안해주면 초기 지점 방문 처리 안됨.
		if(direct==1) {	  
			moveClock(nth); 
		}else {
			moveCountClock(nth); 
		}
		if(nth-1>=0) { //checked return으로 해버리면 뒤에 단 안돎.
			if(!visited[nth-1]) {
				if(copyMap[nth][6]!=copyMap[nth-1][2]) {
					visited[nth-1]=true;
					move(nth-1,-direct);
				}
			}
		}
		if(nth+1<=3) { //부등호 주의.
			if(!visited[nth+1]) {
				if(copyMap[nth][2]!=copyMap[nth+1][6]) {
					visited[nth+1]=true;
					move(nth+1,-direct);
				}
			}
		}
		
	}
	private static void moveClock(int nth) {
		int temp = map[nth][W-1];
		for (int i = W-1; i >0; i--) { //i가 먼저 나와야함 그래서 i-1참조시에는 뒤에서 부터 반복문 + i>0 유의 (원래는 i>=0)
			map[nth][i]=map[nth][i-1];
		}
		map[nth][0]= temp; //마지막에 삽입.
	}
	private static void moveCountClock(int nth) {
		int temp = map[nth][0];
		for (int i = 0; i < W-1; i++) {
			map[nth][i]=map[nth][i+1]; //유의.
		}
		map[nth][W-1]= temp;
	}
	private static void copyArr(int[][] data1, int[][] data2) {
		for (int i = 0; i < D; i++) {
			System.arraycopy(data1[i], 0, data2[i], 0, W); //system은 대입 없음.
		} 
		
	}


}

