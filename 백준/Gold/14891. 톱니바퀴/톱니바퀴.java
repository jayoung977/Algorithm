import java.io.*;
import java.util.*;
public class Main {
	static final int W = 8;
	static final int D = 4;
	static int[][] map;
	static int [][] copyMap;
	static int N;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[D][W];
		for (int i = 0; i < D; i++) {
			char [] temp = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				map[i][j]=temp[j]-'0';
			}
		}

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			visited = new boolean[4];
			st = new StringTokenizer(br.readLine());
			copyMap = new int [D][W];
			copyArr(map,copyMap);
			int nth = Integer.parseInt(st.nextToken())-1;
			int direct = Integer.parseInt(st.nextToken());
			move(nth,direct);
		}
		int sum = 0;
		
		sum += (map[0][0]==1?1:0);
		sum += (map[1][0]==1?2:0);
		sum += (map[2][0]==1?4:0);
		sum += (map[3][0]==1?8:0);
		
		System.out.println(sum);
		
		

	}
	private static void move(int nth, int direct) {
		visited[nth]=true;
		if(direct==1) {	
			moveClock(nth); 
		}else {
			moveCountClock(nth); 
		}
		if(nth-1>=0) {
			if(!visited[nth-1]) {
				if(copyMap[nth][6]!=copyMap[nth-1][2]) {
					visited[nth-1]=true;
					move(nth-1,-direct);
				}
			}
		}
		if(nth+1<=3) {
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
		for (int i = W-1; i >0; i--) {
			map[nth][i]=map[nth][i-1];
		}
		map[nth][0]= temp;
	}
	private static void moveCountClock(int nth) {
		int temp = map[nth][0];
		for (int i = 0; i < W-1; i++) {
			map[nth][i]=map[nth][i+1];
		}
		map[nth][W-1]= temp;
	}
	private static void copyArr(int[][] data1, int[][] data2) {
		for (int i = 0; i < D; i++) {
			System.arraycopy(data1[i], 0, data2[i], 0, W);
		}
		
	}


}
		
