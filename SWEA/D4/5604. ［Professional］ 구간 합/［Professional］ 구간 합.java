import java.io.*;
import java.util.*;
public class Solution {
static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T;
	static long A, B; // A와B의 최대는 10^15
	static long [] cnts;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			A = Long.parseLong(tokens.nextToken());
			B = Long.parseLong(tokens.nextToken());
			
			cnts = new long[10]; // 0부터 9까지 숫자들이 몇 번이나 나오는지 저장할 배열
			// 증가시켜야 할 개수 단위
			long delta = 1;
			while(A<=B) {
				// 위쪽 짜투리
				for(; A%10!=0 && A<=B; A++) {
					parse(A, delta);
				}
				// 아래쪽 짜투리
				for(; B%10!=9 && A<=B; B--) {
					parse(B, delta);
				}
				// A: 33, B:34 이었다면.. 이 시점에서 A는? 35
				if(A>B) {
					break;
				}
				// 이제 남은것 1 - 0~9까지의 row를 처리한다. - row의 개수만큼 추가.
				// 40 ~ 129 까지는 몇 개의 row?
				A/=10; // 4
				B/=10; // 12
				long rowCnt = B-A+1;
				for(int i=0; i<10; i++) {
					cnts[i]+=rowCnt*delta;
				}
				delta*=10;
			}// cnt 처리 완료!!
			
			long sum = 0;
			for(int i=1; i<10; i++) {
				sum+=i*cnts[i];
			}
			output.append("#").append(t).append(" ").append(sum).append("\n");
			
		}// testcase
		System.out.println(output);
	}
	
	private static void parse(long x, long delta) {
		// 123 --> 3, 2, 1
		while(x>0) {
			cnts[(int)(x%10)]+=delta;
			x/=10;
		}
	}

}