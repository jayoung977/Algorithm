

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int R;
	static int[] p;
	static int[] nums;	
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited=new boolean[N];
		p = new int[N];
		for(int i=0;i<N;i++) {
			p[i]=i+1;
		}
		nums = new int[R];
		perm(0);
	}

	static void perm(int cnt) {
		if(cnt==R) {
			String data = Arrays.toString(nums);
			data = data.replaceAll("\\]", "").replaceAll("\\[", "").replaceAll(",", "");
			System.out.println(data);
			return;
		}for (int i = 0; i < N; i++) {
			if(visited[i])continue; //방문했으면 다음 스텝
			visited[i]=true;
			nums[cnt]=p[i]; //많이 틀림 
			perm(cnt+1); //3이전에는 밑으로 안내려감 
			nums[cnt]=0; //2일때 0
			visited[i]=false;
		}
	}

}
