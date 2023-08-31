import java.io.*;
import java.util.*;
/*
 @조건:
 - 구술을 쏘아 벽돌을 깨트리는 게임
 - 구슬은 N번만 쏠 수 있다
 - 게임의 규칙
 - 구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다
 - 벽돌은 숫자 1 ~ 9 로 표현되며,
   구술이 명중한 벽돌은 상하좌우로 ( 벽돌에 적힌 숫자 - 1 ) 칸 만큼 같이 제거된다.
 - 제거되는 범위 내에 있는 벽돌은 동시에 제거된다.
 - N 개의 벽돌을 떨어트려 최대한 많은 벽돌을 제거하려고 한다.
 - 남은 벽돌의 개수를 구하라!
 
 @자료형
 
 - Cell: class r,c,s
 - copy[H][W] int 
 
 
 @아이디어:
 
new copy[H][W] //배열 복사
copy(map,copy)
cnt = h
dfs(cnt){
 	if(cnt==H){
 		answer = Math.min(answer,count());
 		return;
 	}
	Cell [] firsts = findFirst(); //맨 위 좌표들.
	for(int i=0;i<firsts.length;i++){ //맨위 좌표 순회.
//		int r = firsts[i].r;
//		int c = firsts[i].c;
//		break(r,c,map[r][c]);  //map 변형.
		break(firsts[i]); Cell 안에 다 있으니
		push()
		dfs(cnt+1);
		copy(copy,map) //map 복구.
 	
 	}
 
 
 }
 
 

 
 - 돌아가면서 터뜨린다.(break 함수 구현 )
// 	- break(r,c,map[r][c]): 
    - break(Cell): 
 	- 자신 중심 map[r][c](size)만큼 상하좌우 탐색.(nr,nc)
 	int nr = Cell.r;
 	int nc = Cell.c;
 	int size = Cell.size;
 	while(d<4)
	 	for(int i=1; i<size;i++){
	 		nr += dr[d];
	 		nc += dc[d];
	 		if(!check)
	 		if(map[nr][nc]!=1){
	 			 break(nr,nc) // 1아니면 또 다시 dfs
	 		}else{
	 			map[nr][nc]= 0 //1이면 0으로 변환 
	 		}
 		}
 		d++;
 	
 	}


 	
 - push()함수 실행
 		- 2중 for
 		- 열방향 탐색해서 0이 아니면 임시 배열에 저장 int tmp[] = new int[H+1] 및 지우;
 		- 다시 넣기.
 		for(W){
 			int idx = 0;
 			for(H){
 				if(map[H][W]!=0){
 					int tmp[idx]=map[H][W];
 					map[H][W] = 0;
 					idx++;
 				}
 			}
 			for(int h=0;h<idx+1;h++){
 				map[H-(idx+1)+h][W] = tmp[h];
 			}
 			
 		
 		}
 */
public class Solution {
	static class Cell{
		int r;
		int c;
		int size;
		public Cell(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
		
		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", size=" + size + "]";
		}
	}
	static int T;
	static int N,W,H;
	static int[][] map;
	static int answer;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			init();
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력끝
			dfs(1);
			if(answer == Integer.MAX_VALUE/1000) {
				answer =0;	
			}
			System.out.println("#"+t+" "+answer);
			
			
			
			
		}
	}
	static void dfs(int cnt) {
//		System.out.println("cnt: "+cnt);
		Cell [] firsts = new Cell [W];
//		if(cnt==H) {
//			System.out.println("===================================cnt"+cnt+"===============================");
//			answer = Math.min(answer, count());
//			return;
//		}
		firsts = findFirst();  //맨 위 좌표들 찾기.
		if(cnt==N+1) {
			answer = Math.min(answer, count());
//			System.out.println("---------------------cnt "+cnt+" answer: "+answer+"위까지.-----------------------------------");
			return;
		}
//		System.out.println("========firsts===========");
//		System.out.println(Arrays.toString(firsts));
		for (Cell cell: firsts) {//맨위 좌표 순회
			if(cell==null) continue;
			int[][] copy = new int[H][W];
			copyArr(map,copy);
//			System.out.println("========cur cell===========");
//			System.out.println("cell: "+ cell);
			breaking(cell);
			push();
//			System.out.println("========map===========");
//			for (int i = 0; i < H ;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			dfs(cnt+1);
			copyArr(copy,map);
			
		}
		
		
	}


	private static boolean isNull(Cell[] firsts) {
		for (int i = 0; i < firsts.length; i++) {
			if(firsts[i]!=null) {
				return false;
			}
		}
		return true;
	}
	static void push() {
		for (int i = 0; i < W; i++) {
 			int idx = 0;
 			int[] tmp =  new int[H]; //매 열마다 0아닌 값 저장.
 			for (int j = 0; j < H; j++) {
 				if(map[j][i]!=0){ //i열에서 0아닌값 확인 
 					tmp[idx]=map[j][i];
 					map[j][i] = 0; //저장 후 0으로 지움.
 					idx++; //7
 					
 				}
 			}
 			for(int j=0; j <idx; j++){ // 재배치 
 				map[(H-idx)+j][i] = tmp[j]; //i열의 H-(idx+1)+j행부터재배치 
 			}
 			
 		
 		}
		
	}
	static void breaking(Cell cell) {
//		System.out.println("cell: "+cell);
//	 	System.out.println("nr: "+nr+" nc: "+nc+" size:"+size);
	 	if(cell.size==1) { //맨 위라 0일 수 없음.
	 		map[cell.r][cell.c] = 0; 
//	 		System.out.println("size1 return");
	 		return;
	 	}
	 	Queue<Cell> q= new LinkedList<>();
	 	q.offer(cell);
	 	int count =0;
	 	while(!q.isEmpty()) {
	 		count++;
//	 		System.out.println("count: "+count);
		 	int size = q.size();
		 	while(size-->0){
		 		Cell cur =  q.poll();
		 		map[cur.r][cur.c]= 0; 
		 		for (int d = 0; d < dc.length; d++) {
		 			for (int i = 1; i < cur.size; i++) {
		 				int nr = cur.r+(dr[d]*i);
		 				int nc = cur.c+(dc[d]*i);
//		 				System.out.println("i: "+i);
//		 				System.out.println("nr: "+nr+" nc: "+nc);
		 				if(!check(nr,nc)) continue;
		 				if(map[nr][nc] > 1){
		 					q.offer(new Cell(nr,nc,map[nr][nc]));
		 					map[nr][nc]= 0; 
		 				}else if(map[nr][nc]==1) {
		 					map[nr][nc]= 0;
		 					}
		 		
		 				}
		 			}
					
				}
		 		
		 }
	 }
//	 	int d = 0;
//
//		while(d<4)
//	 		for(int i=1;i<size;i++){
//		 		System.out.println("i: "+i);
//		 		nr += dr[d];
//		 		nc += dc[d];
//		 		if(!check(nr,nc)) break;
//		 		System.out.println("nr: "+nr+" nc: "+nc);
//		 		if(map[nr][nc] > 1){
//		 			int tempSize = map[nr][nc];
//		 			map[nr][nc]= 0; 
////		 			breaking(new Cell(nr,nc,tempSize)); // 1아니면 또 다시 dfs
//		 		}else if(map[nr][nc]==1) { //1이면 0으로 변환 
//		 			map[nr][nc]= 0; 
//		 		}
//	 		}
//	 		d++;
	 	
//	}
		
	static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<H && c<W;
	}
	static Cell[] findFirst() {
		Cell [] firsts = new Cell [W];
		int idx = 0;
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if(map[j][i]!=0) {
					firsts[idx] = new Cell(j,i,map[j][i]);
					idx++;
					break;
				}
			}
		}
//		System.out.println("first");
//		System.out.println(Arrays.toString(firsts));
		return firsts;
	}
	static int count() {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]!=0) {
					count++;
				}
			}
		}
		return count;
	}
	static void copyArr(int[][] data1, int[][] data2) {
		for (int i = 0; i < H; i++) {
			System.arraycopy(data1[i], 0, data2[i], 0, W);
		}
		
	}
	static void init() {
		map = new int[H][W];
		answer = Integer.MAX_VALUE/1000;
	}

}
