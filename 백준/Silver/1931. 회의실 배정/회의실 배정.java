import java.io.*;
import java.util.*;

public class Main {
	static class Room {
		int start;
		int end;
		public Room(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	static class RoomComp implements Comparator<Room> {

		@Override
		public int compare(Room o1, Room o2) {
			int t = Integer.compare(o1.end, o2.end);
			if(t==0) return Integer.compare(o1.start, o2.start) ;
			return t;
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Room> rooms = new ArrayList<>();
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			rooms.add(new Room(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		rooms.sort(new RoomComp());
		int count = 0;
		int prev = 0;
		for(Room r:rooms) {
			if(prev <=r.start) {
				prev = r.end;
				count++;
			}
			
		}
		System.out.println(count);
		
		
		
	}
	
}
