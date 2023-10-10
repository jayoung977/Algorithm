import java.util.*;
import java.io.*;
public class Main {
	static int R,C,T;
	static int[][] map;
	static int[][] cleaner;
	static int[][] temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cleaner = new int[2][2];
		boolean first=false;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1 && !first) {
					cleaner[0][0]=i;
					cleaner[0][1]=j;
					first =true;
				}else if(map[i][j]==-1 && first) {
					cleaner[1][0]=i;
					cleaner[1][1]=j;
				}
			}
		}
//		System.out.println(Arrays.deepToString(cleaner));
		int t=0;
		int dust=0;
		while(t<T) {
			spread();
			airClean();
			dust = countDust();
			t++;
		}
		System.out.println(dust);

	}
	static int[] dr= {0,-1,0,1,0,1,0,-1};//시계4 - 반시계4
	static int[] dc= {1,0,-1,0,1,0,-1,0};
	static void spread() {
		temp = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				int dust = map[i][j]/5;
				int cnt = 0;
				if(map[i][j]!=-1 && dust!=0) {
					for(int d=0; d<4; d++) {
						int nr = i+dr[d];
						int nc = j+dc[d];
						if(!(nr>=0 && nc>=0 && nr<R && nc<C)) continue;
						if(map[nr][nc]==-1) continue;
						cnt++;
						temp[nr][nc]+=dust;
					}
					temp[i][j]+=map[i][j]-cnt*dust;
					
				}else if(map[i][j]!=0 && dust==0) temp[i][j]+=map[i][j];
			}
		}
		for(int i=0; i<R; i++) {
			System.arraycopy(temp[i],0,map[i],0,C);
		}
//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	
	static void airClean() {
		
		temp = new int[R][C];
		for(int i=0; i<R; i++) {
			System.arraycopy(map[i],0,temp[i],0,C);
		}
        //반시계
		int idx=0;
		int r =  cleaner[0][0];
		int c =  cleaner[0][1];
		int nr = r;
		int nc = c;
		while(idx<4) {
			nr = r+dr[idx];
			nc = c+dc[idx];
			//범위 벗어나면 방향 바꿈 혹은 마지막 좌표가 공기청정기면 방향 +1해줘서 끝냄
			if(!(nr>=0 && nc>=0 && nr<R && nc<C)||nr==cleaner[0][0] && nc==cleaner[0][1]) { 
				idx++; 
				continue;
			}
//			System.out.println("idx: "+idx+" nr: "+nr+", nc: "+nc+" | r: "+r+", c: "+c);
			if(map[r][c]==-1) temp[nr][nc]=0; //이전이 공기청정기면
			else temp[nr][nc]=map[r][c];
			
			r = nr;
			c = nc;
		}
		
		
		
		
		//시계
		idx=4;
		r =  cleaner[1][0];
		c =  cleaner[1][1];
		nr = r;
		nc = c;
		while(idx<8) {
			nr = r+dr[idx];
			nc = c+dc[idx];
			//범위 벗어나면 방향 바꿈 혹은 마지막 좌표가 공기청정기면 방향 +1해줘서 끝냄
			if(!(nr>=0 && nc>=0 && nr<R && nc<C)||nr==cleaner[1][0] && nc==cleaner[1][1]) { 
				idx++; 
				continue;
			}
//			System.out.println("idx: "+idx+" nr: "+nr+", nc: "+nc+" | r: "+r+", c: "+c);
			if(map[r][c]==-1) temp[nr][nc]=0; //이전이 공기청정기면
			else temp[nr][nc]=map[r][c];
			
			r = nr;
			c = nc;
		}
		
		
		for(int i=0; i<R; i++) {
			System.arraycopy(temp[i],0,map[i],0,C);
		}
		
//		System.out.println("====================clean======================");
//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(temp[i]));
//		}
		
	}
	
	static int countDust() {
		int sumDust = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) sumDust+=map[i][j];
			}
		}
		return sumDust;
	}

}