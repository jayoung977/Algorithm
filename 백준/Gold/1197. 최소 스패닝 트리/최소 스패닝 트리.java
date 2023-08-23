
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
  static int V, E;
  static long min;

  static class Edge implements Comparable<Edge> {
    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
      super();
      this.s = s;
      this.e = e;
      this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.w, o.w);// 작은거에서 큰걸로 , 이 자체가 this.w- o.w
    }

  }

  static PriorityQueue<Edge> points;
  static int[] p;
  static int[] r;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    points = new PriorityQueue<>(); // () Comparable
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      points.offer(new Edge(s, e, w));
    }
    p = new int[V + 1];
    r = new int[V + 1];
    makeSet();
    int cnt = 0; // V-1회 반복
    min = 0;
    while (cnt != V - 1) {
      Edge edge = points.poll();
      if (union(edge.s, edge.e)) { // 부모 같냐
        cnt++;
        min += edge.w;
      }
    }
    System.out.println(min);

  }

  private static boolean union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) // 부모 같으면 cycle발생하므로 더 안돌게 false 반환
      return false;
    if (r[x] < r[y]) { // cycle없으면 연결함
      r[y] += r[x];
      p[x] = y;
    } else {
      r[x] += r[y];
      p[y] = x;
    }
    return true;
  }

  private static int find(int x) {
    if (x == p[x])
      return p[x];
    else
      return p[x] = find(p[x]);
  }

  private static void makeSet() {
    for (int i = 0; i < V + 1; i++) {
      p[i] = i;
    }
    for (int i = 0; i < V + 1; i++) {
      r[i] = 1;
    }

  }

}
