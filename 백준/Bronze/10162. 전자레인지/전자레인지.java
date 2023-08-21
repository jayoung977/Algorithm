import java.io.*;
import java.util.*;
public class Main {
	static int T; //요리시간
	static int A,B,C; //각 값 
	static int min_cnt = Integer.MAX_VALUE; //a+b+c 최소가 되는 횟수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
		T = Integer.parseInt(br.readLine()); // 요리 시간 입력
		A = B = C = -1; // 만약 최소 횟수 못구했을 경우 초기값 -1
		dfs(T,0,0,0); //dfs
		if(A==-1) { // 최소 횟수 못구했을 경우 초기값 -1
			System.out.println(-1); //-1 출력
			return; //리턴
		}
		System.out.println(A+" "+B+" "+C); //최솟값을 구했을 경우 전부 횟수 출력
		

	}
	private static void dfs(int tot, int a, int b, int c) { //dfs
		if(tot == 0) { // dfs 돌다가 tot ==0인 경우 
			int cnt = a+b+c; // a+b+c로 횟수 계산
			if(min_cnt>cnt) { // 최소 회수 인경우
				min_cnt = cnt; //min_cnt에 값 저장 
				A = a; //A에 값 저장
				B = b; //B에 값 저장
				C = c; //C에 값 저장 
			}
			return; //리턴
		}else if(tot<0) { //만약 최소값을 구하지 못한 경우
			return; //리턴
		}
		dfs(tot-300,a+1,b,c); //첫번째 5분
		dfs(tot-60,a,b+1,c);  //두번째 1분
		dfs(tot-10,a,b,c+1);  //세번째 10초
		
		
	}

}
