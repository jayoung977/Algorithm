import java.io.*;
import java.util.*;
public class Solution {
	static int T,N,R;
	static long answer;
	static int mod = 1234567891;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		long [] factorial = new long[1000001];
		factorial[0]=1;
		for(int i=1; i<1000001; i++) factorial[i]=(i*factorial[i-1])%mod;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			answer=(factorial[N]*pow((factorial[R]*factorial[N-R])%mod,mod-2))%mod;
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static long pow(long a, long b) {
		if(b==0) return 1;
		long ans = pow(a,b/2);
		long next = (ans*ans)%mod;
		if(b%2==0) return next;
		return (next*a)%mod;
	}
	

}