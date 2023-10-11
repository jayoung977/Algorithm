import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static class Node implements Comparable<Node>{
    	int r,c,w;
    	public Node(int r, int c, int w) {
    		this.r=r;
    		this.c=c;
    		this.w=w;
    	}
    	@Override
    	public int compareTo(Node o) {
    		return Integer.compare(this.w, o.w);
    	}
    }
    static int[][] visited;
    static PriorityQueue<Node> points;
    static int MM = Integer.MAX_VALUE/1000;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t=1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)break;
			map=new int[N][N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			visited=new int[N][N];
			for(int i=0; i<N; i++) Arrays.fill(visited[i], MM);
			visited[0][0]=map[0][0];
			
			points=new PriorityQueue<>();
			points.offer(new Node(0,0,map[0][0]));
			
			bfs();
//			for(int i=0; i<N; i++)System.out.println(Arrays.toString(visited[i]));
//			System.out.println("============================");
			System.out.println("Problem "+t+": "+ visited[N-1][N-1]);
			t++;
			
			
			
		}
	}
	static void bfs() {
		while(!points.isEmpty()) {
			Node cur = points.poll();
			if(cur.r==N-1 && cur.c==N-1) break;
			for(int d=0; d<4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				if(!(nr>=0 && nc>=0 && nr<N && nc<N)) continue;
				if(visited[nr][nc]!=MM) continue;
				if(visited[nr][nc]>visited[cur.r][cur.c]+map[nr][nc]) {
					visited[nr][nc]=visited[cur.r][cur.c]+map[nr][nc];
//					System.out.println("visited[nr][nc]:"+visited[nr][nc]);
					points.offer(new Node(nr,nc,visited[nr][nc]));
				}
			}
		}
	}

}
/*
 굳이 행렬을 인접리스트 형태로 만들 필요 없
 */