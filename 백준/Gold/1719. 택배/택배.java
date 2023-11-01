import java.io.*;
import java.util.*;

	public class Main {

	    static int n, m;
	    static int[][] map;
	    static int[][] pointMap;

	    private static final int MAX = Integer.MAX_VALUE/1000;

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());

	        map = new int[n + 1][n + 1];
	        pointMap = new int[n + 1][n + 1];

	        for (int i = 1; i <= n; i++) {
	            Arrays.fill(map[i], MAX);
	        }

	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n; j++) {
	                pointMap[i][j] = j;
	            }
	        }


	        int A, B, W;
	        for (int i = 0; i < m; i++) {
	        	st = new StringTokenizer(br.readLine());
	            A = Integer.parseInt(st.nextToken());
	            B = Integer.parseInt(st.nextToken());
	            W = Integer.parseInt(st.nextToken());

	            map[B][A] = map[A][B] = W;
	        }
	


	        for (int k = 1; k <= n; k++) {
	            for (int i = 1; i <= n; i++) {
	                for (int j = 1; j <= n; j++) {
	                	if(i==j || i==k || j==k) continue;
	                    if (map[i][j] > map[i][k] + map[k][j]) {
	                        map[i][j] = map[i][k] + map[k][j];
	                        pointMap[i][j] = pointMap[i][k];
	                    }
	                }
	            }
	        }


	        StringBuilder sb = new StringBuilder();

	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n; j++) {
	                if (i == j) {
	                    sb.append('-').append(' ');
	                    continue;
	                }
	                sb.append(pointMap[i][j]).append(' ');
	            }
	            sb.append('\n');
	        }

	        System.out.print(sb);
	    }
	}