import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int minNum = Integer.MAX_VALUE;
	static int ans;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		ans = 0;
		
	
		q.offer(new int[] {N,0});
		bfs();
		System.out.println(minNum);
		

	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int n = cur[0];
			int cnt = cur[1];
			if(n==1) {
				minNum =  Math.min(minNum,cnt);
				break;
			} 
			if(n%3==0 ) {
				q.offer(new int[] {n/3,cnt+1});
			}
			if(n%2==0 ) {
				q.offer(new int[] {n/2,cnt+1});
			}
			
			q.offer(new int[] {n-1,cnt+1});
		}
	}
		
			
			
			

		
		
	}


