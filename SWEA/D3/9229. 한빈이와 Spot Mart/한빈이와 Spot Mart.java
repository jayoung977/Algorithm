import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N;
	static int M;
	static int[] snakWeights;
	static int[] nums;
	static int tot;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snakWeights = new int[N];
			nums = new int[2]; //[,]
			tot = 0;
			answer = -1;

			st = new StringTokenizer(br.readLine());
			for(int j=0; j <N; j++) {
				snakWeights[j] = Integer.parseInt(st.nextToken());
			}
			choice(0,0,0);
			System.out.printf("#%d %d",i,answer);
			System.out.println();
			
			
			
		}
	}
	static void choice(int cnt, int start, int tot) {
		if(tot>M) return;
		if(cnt==2 ) {
			//로직
//			System.out.println(Arrays.toString(nums));
			answer = Math.max(answer, tot);
			return;
		}
		for(int i=start; i<N;i++) {
			nums[cnt] = snakWeights[i];
			choice(cnt+1,i+1,tot+nums[cnt]);

		}
		
		
	}

}


//4
//3 45
//20 20 20
//6 10
//1 2 5 8 9 11
//4 100
//80 80 60 60
//4 20
//10 5 10 16
