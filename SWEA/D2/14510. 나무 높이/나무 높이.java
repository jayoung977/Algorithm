import java.util.*;
import java.io.*;
public class Solution {
	static int T,N;
	static int[] map;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); 
		dp = new int[10000];
		dp[0]=1;
		dp[1]=3;
		for(int i=2; i<dp.length; i++) {
			dp[i]+=(dp[i-1]+(i%2)*2+(i+1)%2*1);
		}
		//System.out.println(Arrays.toString(dp));
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine()); 
			StringTokenizer st = new StringTokenizer(br.readLine());
			map = new int[N];
			
			int maxNum = 0;
			for(int i=0; i<N; i++) {
				map[i]=Integer.parseInt(st.nextToken());
				maxNum=Math.max(map[i], maxNum);
			}
			int odd=0;
			int even=0;
			for(int i=0; i<N; i++) {
				odd+=(maxNum-map[i])%2;
				even+=(maxNum-map[i])/2;
			}
			if(odd==0&&even==0) {
				System.out.println("#"+t+" "+0);
				continue;
			}
//			System.out.println("odd: "+odd+", even:"+even);
			int minCnt=0;
			int maxCnt=0;
			boolean isOdd=false;
			if(odd>even) {
				maxCnt=odd;
				minCnt=even;
				isOdd=true;
			}else {
				maxCnt=even;
				minCnt=odd;
//				System.out.println("maxCnt:"+maxCnt);
//				System.out.println("(maxCnt-minCnt)*2:"+(maxCnt-minCnt)*2);
			}
			int answer=minCnt*2;
//			int answer = (int) (minCnt*2+Math.ceil((maxCnt-minCnt)*2.0/3)*2);
			if(maxCnt==minCnt) {
				System.out.println("#"+t+" "+answer);
				continue;
			}
			if(isOdd) answer+=(int) (maxCnt-minCnt)*2.0-1;
			else {
				int idx = -Arrays.binarySearch(dp, (maxCnt-minCnt)*2);
				if(idx<0) idx=-idx+1;
//				System.out.println("idx: "+idx);
				answer +=  idx;
			}
			System.out.println("#"+t+" "+answer);
		}
		
	}

}
