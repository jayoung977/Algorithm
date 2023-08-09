

import java.io.*;
import java.util.*;

class Main{
	static int N;
	static int data;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		check = new boolean[988]; //987까지
		//가능한 모든 수 
		for (int i = 123; i <= 987; i++) {
			String num = String.valueOf(i); //문자열 형태로 저장
			if(num.charAt(0)=='0'||num.charAt(1)=='0'||num.charAt(2)=='0') continue;
			if(num.charAt(0)==num.charAt(1)||num.charAt(0)==num.charAt(2)||num.charAt(1)==num.charAt(2)) continue;
			check[i]=true; //가능한 경우에만 인덱스 true표기
		}
		
		for(int i=0; i<N; i++) {
			//입력 끝
			 st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			for(int p=123; p <= 987; p++) {
    			if(check[p]) { // 정답일 수 있는 수라면 탐색
    				
    				int strike_n = 0;
    				int ball_n = 0;
    				
    				// 입력 받은 숫자 num의 위치별(0<j<3)로 점검
    				for(int j=0; j<3; j++) {
    					char num_split = Integer.toString(num).charAt(j);
    					
    					// 정답일 수 있는 숫자 p의 위치별(0<k<3)로 점검
    					for(int k=0; k<3; k++) {
    						char p_split = Integer.toString(p).charAt(k);
    						
    						if(num_split == p_split && j == k) strike_n++; // 둘의 숫자가 같으면서 위치도 같다면 스트라이크
    						else if(num_split == p_split && j != k) ball_n++; // 둘의 숫자는 같은데 위치는 다르면 볼
    					}
    				}
    				
    				if(strike_n == strike && ball_n == ball) check[p] = true; // 입력받은 스트라이크와 볼의 갯수와 같아진다면 가능성 있는 수로 판별
    				else check[p] = false; // 아니라면 가능성 박탈
    			}
    		}
    	}
    	
    	int p_n = 0;
    	for(int i=123; i<=987; i++) {
    		if(check[i]) p_n++;
    	}
    	System.out.println(p_n); //가능성있는 개수 
		
		
		

	}
	

}
