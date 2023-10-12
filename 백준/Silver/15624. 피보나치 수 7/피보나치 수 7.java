import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[1000001];
		dp[0]=0;
		dp[1]=1;
		for(int i=2; i<dp.length; i++) {
			dp[i]=(dp[i-1]+dp[i-2])%1000000007;
		}                      
		System.out.println(dp[N]);

	}

}
