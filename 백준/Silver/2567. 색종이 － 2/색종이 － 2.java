import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int [][] map;
	static int cnt; 
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[101][101]; //도화지, 자연수 입력은 그냥 101
        cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					map[j][k]=1;
				}
			}
		}
		//범위가 100까지라 k+1쓰면 안되고 k-1써야
		for (int j = 1; j < 101; j++) {
			for (int k = 1; k < 101; k++) {
				if(map[j][k-1]!=map[j][k]) cnt++;
				if(map[k-1][j]!=map[k][j]) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
