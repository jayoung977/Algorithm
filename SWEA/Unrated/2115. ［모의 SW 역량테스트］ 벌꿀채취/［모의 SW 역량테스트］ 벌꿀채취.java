
import java.util.*;
import java.io.*;
public class Solution {
	static int T,N,M,C,maxA,maxB;
	static int[][] map;
	static boolean[] visited;
	static class Node{
		int r,c,h;
		public Node(int r, int c, int h) {
			this.r=r;
			this.c=c;
			this.h=h;
		}
		@Override
		public String toString() {
			return "[r: "+r+",c: "+c+",h: "+h+"]";
		}
		@Override
		public boolean equals(Object obj) {
			 boolean sameSame = false;

		        if (obj != null && obj instanceof Node)
		        {
		            sameSame = this.r == ((Node) obj).r && this.c == ((Node) obj).c;
		            
		        }

		        return sameSame;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken()); 
			M=Integer.parseInt(st.nextToken()); 
			C=Integer.parseInt(st.nextToken()); 
			map=new int[N][N];

			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken()); 
				}
			}
			List <ArrayList<Node>> list = new ArrayList<>();
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<=N-M; j++) {
					list.add(new ArrayList<Node>());
					for(int k=0; k<M; k++) {
						list.get(cnt).add(new Node (i,j+k,map[i][j+k]));
					}
					cnt++;
				}
			}
			// 확인 용
//			for(int i=0; i<list.size(); i++) {
//				System.out.print("i: "+i+" ");
//				for(Node arr:list.get(i)) {
//					System.out.print(arr+" ");
//				}
//				System.out.println();
//			}
			//조합
			List<int[]> combiList = new ArrayList<>();
			for(int i=0; i<list.size(); i++) {
				for(int j=i+1; j<list.size(); j++) {
					if(!list.get(j).contains(list.get(i).get(M-1))) { //겹칩 확인.
//						System.out.println("i: "+i+", j:"+j);
						combiList.add(new int[] {i,j});
					}
				}
			}
			
			//채취 
			int answer = 0;
		
			for(int i=0; i<combiList.size(); i++) {
				maxA=0;
				maxB=0;
				//양봉업자 A씨의 최대 수익/
				int a = combiList.get(i)[0];
				calMaxIncome(list.get(a),true);
				//양봉업자 B씨의 최대 수익/
				int b = combiList.get(i)[1];
				calMaxIncome(list.get(b),false);
//				System.out.println("maxA+maxB: "+(maxA+maxB));
				answer = Math.max(maxA+maxB,answer);
				
			}
			System.out.println("#"+t+" "+answer);
			
		
		}
		

	}
	static void calMaxIncome(ArrayList<Node> p, boolean isA) {
		visited = new boolean[M];
//		if(isA) {
//			System.out.println("--------------------A-----------------------");
//		}else System.out.println("--------------------B--------------------");
		combi(p,0,0,0,isA);
		return;
	}
	static void combi(ArrayList<Node> p, int cnt, int tot, int mul, boolean isA) {
		
		if(tot>C) return;
		if(cnt==M) {
			//로직
//			for (int i = 0; i < M; i++) {
//				if(visited[i]) System.out.print(p.get(i)+" ");
//			}
			if(isA) {
				maxA= Math.max(mul,maxA);
			}else maxB= Math.max(mul,maxB);
			
//			System.out.println();
//			System.out.println(tot);
//			System.out.println(mul);
//			System.out.println("======================");
			return;
		}
		visited[cnt]=true;
		combi(p,cnt+1,tot+p.get(cnt).h,mul+p.get(cnt).h*p.get(cnt).h,isA);
		visited[cnt]=false;
		combi(p,cnt+1,tot,mul,isA);
	}

}
