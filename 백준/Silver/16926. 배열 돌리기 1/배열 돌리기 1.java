import java.util.*;

public class Main {
	private static int[] dx = {0,1,0,-1};//우상좌하
	private static int[] dy = {1,0,-1,0}; //우상좌하
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //배열크기
		int M = sc.nextInt(); //배열크기
		int R = sc.nextInt(); //회전 수
		
		int[][] arr = new int[N][M]; //배열 선언
		
		//배열 입력
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//돌려야하는 그룹 개수
		//2*2 행렬에서는 1개, 5*5에서는 2개, 4*5에서는 2개, 최솟값을 2로 나누면 그룹 수가 나온다.
		//이 규칙에서 항상 시작점은 x,y값이 같은 값에서 시작
		int group_value = Math.min(N, M) / 2;
		
		
		//회전횟수
		for(int i=0;i<R;i++) {
			//그룹 갯수만큼 반복
			for(int j=0;j<group_value;j++) {
				int x = j;
				int y = j;
				
				//나중에 값을 넣기 위해 따로 저장
				int value = arr[x][y];
				
				int idx=0;// 방향
				
				while(idx<4) {
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					
					//범위 내에 있을 경우 돌려
					if(nx>=j&&ny>=j&&nx<N-j&&ny<M-j) {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}
					//범위 벗어나면 방향 전환
					else idx++;
				}
				arr[j+1][j] = value;
			}
		}
		
		//출력
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}