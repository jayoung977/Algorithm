import java.util.*;

//public class PermTest3  {
public class Main  {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] p = new int[n];
        int[] nums = new int[n];
        boolean[] visited  = new boolean[n];
        for (int i = 0; i < n; i++) {
        	p[i] = i+1;
			
		}
        perm(0,n,p,nums,visited);
    } 
    static void perm(int cnt, int n,int[] p,int[] nums, boolean[] visited) {
    	if(cnt==n) {
    		for(int num:nums) {
    			System.out.print(num+" ");
    		}
    		System.out.println();
    		return;
    	}
    	for(int i=0; i<n; i++) {
    		if(visited[i]) continue;
    		visited[i]=true;
    		nums[cnt]=p[i];
    		perm(cnt+1,n,p,nums,visited);
    		visited[i]=false;
    		
    	}
    }
    
}