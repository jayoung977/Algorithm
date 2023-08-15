import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int r;
	static int c;
	static int tot;
	static int size_save;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		tot = 0;
		size_save = (int)Math.pow(2, N);
		count(0,0,(int)Math.pow(2, N));
		System.out.println(tot);

	}

	private static void count(int startR, int startC, int size) {
		
		if(size == 0) return;
		if(size >size_save ) return; //더 깊게 들어간게 아니라 범위 이후를 본다면(범위를 벗어난 이전 사이즈일경우)
		
		if(!check(startR,startC,size)) {//r,c가 묶음보다 크면 
			tot+=size*size;
			return;
		}
		size=size/2;
		size_save = size;
		count(startR,startC,size);
		count(startR,startC+size,size);
		count(startR+size,startC,size);
		count(startR+size,startC+size,size);
		
	}


	private static boolean check(int startR, int startC,int size) {
		return (startR<=r && r<startR+size && startC<=c &&  c<startC+size) ;
	}

}
