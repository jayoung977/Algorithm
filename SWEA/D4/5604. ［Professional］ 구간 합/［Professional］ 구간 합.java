import java.io.*;
import java.util.*;
public class Solution {
	static int T;
	static long A,B;
	static long[] cnts;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();;
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			cnts = new long[10];
			long delta = 1;
			while(A<=B) {
				//1.위 자투리
				for(;A%10!=0 && A<=B; A++) {
					parse(A,delta);
				}
				//2.아래 자투리
				for(;B%10!=9 && A<=B; B--) {
					parse(B,delta);
				}
				//3.34-35
				if(A>B) break;
				//4.0-9
				A/=10;
				B/=10;
				long rowCnt = B-A+1;
				for(int i=0; i<10; i++) {
					cnts[i]+=rowCnt*delta;
				}
				//5.4-12
				delta*=10;
			}
			long sum=0;
			for(int i=1; i<10; i++) {
				sum+=cnts[i]*i;
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
			
		}
		System.out.println(sb);
		
	}
	static void parse(long x, long delta) {
		while(x>0) {
			cnts[(int)(x%10)]+=delta;
			x/=10;
		}
		
	}


}