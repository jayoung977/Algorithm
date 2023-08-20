
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N=19;
	static int[][] map;
	// 정방향
	//static int [] rdr= {-1,0,1,1};
	//static int [] rdc= { 1,1,1,0};
	// 역방향
	//static int [] dr= { 1, 0,-1,-1};
	//static int [] dc= {-1,-1,-1, 0};
	                   // 역방향           // 정방향
	static int [] dr= { 0,-1, 1,-1, 1,-1,1,0};
	static int [] dc= {-1,-1,-1, 0, 0, 1,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		map=new int[N+2][N+2];  //1흑 2백 0빔
		for (int i = 1; i < N+1; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 로직
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {  // 모든 좌표를 확인해보자. 
				if(map[r][c]!=0) {           // 흑이나 백에서 시작
					for (int d = 0; d <4; d++) { // 4 방향으로 같은 색이 있는가 체크
						int nr=r+dr[d];
						int nc=c+dc[d];
						if(map[nr][nc]==map[r][c]) continue; // 역방항 한개 같은색
						// 정방향으로 연속으로 오직 5개 -> 원하는 결과!!
						if(steps(map[r][c],r,c,7-d)) {
							System.out.println(map[r][c]);
							System.out.println(r+" "+c);
							return ;
						}
					}
				}
			}
		}
		System.out.println("0");
	}

	static boolean steps(int v, int r, int c, int d) {
		int cnt=1;
		for (; v ==map[r+dr[d]][c+dc[d]]; r+=dr[d],c+=dc[d]) {
			cnt++;
		}
		return cnt==5?true:false;
	}
}