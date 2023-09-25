
import java.io.*;
import java.util.*;
public class Main {

	static class Node{
	    int r;
	    int c;
	    Node(int r, int c){
	        this.r=r;
	        this.c=c;
	    }
	    
	    @Override
	    public String toString() {
	    	return "[r: "+r+" , c: "+c+"]";
	    }
	    
	}
	static int N,M;
	static int[][] map;
	static int[][] temp;
	static int[] p;
	static List<Node> list;
	static Node [] walls;
	static int answer;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int count = 0;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    map = new int[N][M];
	    list = new ArrayList<>();
	    walls = new Node[3];
	    answer = 0;
	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < M; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	            if(map[i][j]==0) {
	                list.add(new Node(i,j));
	            }
	        }
	    }
	//    System.out.println(list.size());
	    combi(0,0);
	    System.out.println(answer);
	    
	
	}
	private static void combi(int cnt, int start) {
		
	    if(cnt==3) {
	    	count++;
//	    	System.out.println("count: "+count);
//	    	System.out.println(walls[0]+" "+walls[1]+" "+walls[2]);
	    	temp = new int[N][M];
	    	for(int i=0; i< N; i++) {
	    		System.arraycopy(map[i], 0, temp[i], 0, M);
	    	}
//	    	System.out.println("-------------temp-------------");
//	    	for(int i=0; i< N; i++) {
//	    		System.out.println(Arrays.toString(temp[i]));
//	    	}
	    	
	    	constructWall();
//	    	System.out.println("-------------constructWall-------------");
//	    	for(int i=0; i< N; i++) {
//	    		System.out.println(Arrays.toString(temp[i]));
//	    	}
	    	virus();
//	    	System.out.println("-------------virus-------------");
//	    	for(int i=0; i< N; i++) {
//	    		System.out.println(Arrays.toString(temp[i]));
//	    	}
	    	int safe = count();
	    	answer = Math.max(safe,answer);
	        return;
	    }
	    for(int i=start; i<list.size(); i++) {
	        walls[cnt]=list.get(i);
	        combi(cnt+1,i+1);
	        
	    }
	    
	    
	}
	private static int count() {
		int cnt = 0;
		for(int i=0; i< N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void virus() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j]==2) {
					dfs(i,j);
				}
			}
		}
		
		
		
	}
	private static void dfs(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(temp[nr][nc]==0) {
				temp[nr][nc]=2;
				dfs(nr,nc);
			}
		}
		
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
	private static void constructWall() {
		for(int i=0; i<walls.length; i++) {
			int r = walls[i].r;
			int c = walls[i].c;
			temp[r][c] = 1;
		}
		
	}
}

