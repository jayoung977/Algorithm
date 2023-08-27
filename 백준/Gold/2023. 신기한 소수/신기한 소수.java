import java.io.*;
import java.util.*;
public class Main{
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0,0);
		
	}
	private static void dfs(int num, int cnt) {
		if(cnt==N) {
			System.out.println(num);
			return;
		}
		for (int i = 1; i < 10; i++) {
			int temp = 10*num+i;
			if(isPrime(temp)) {
				dfs(temp,cnt+1);
			}
		}
		
	}
	private static boolean isPrime(int n) {
		if(n<2) return false;
		for (int i = 2; i*i<= n; i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
