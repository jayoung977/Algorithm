import java.io.*;
import java.util.*;
public class Main{
	static int N;
	static int[] dia;
	static int[] undia;
	static int[] cols;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cols = new int[N+1];
		dia = new int[2*N+1];
		undia = new int[2*N+1];
		answer = 0;
		dfs(1);
		System.out.println(answer);

	}
	private static void dfs(int row) {
		if(row==N+1) {
			answer++;
			return;
		}
		for (int col = 1; col <= N; col++) {
			if(!(cols[col]==1 || dia[row+col]==1 || undia[row-col+N+1]==1 )) {
				cols[col]= dia[row+col] = undia[row-col+N+1] = 1;
				dfs(row+1);
				cols[col]= dia[row+col] = undia[row-col+N+1] = 0;
			}
		}
		
	}

}
