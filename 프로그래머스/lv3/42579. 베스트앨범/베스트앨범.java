import java.util.*;
public class Solution {
    static class Node {
         String genre;
         int play;
         int index;
         Node(String genre, int play, int index){
             this.genre=genre;
             this.play=play;
             this.index=index;
         }
        
    }
    static class MyComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            if(map.get(o1.genre) > map.get(o2.genre)){
                return -1;
            }else if(map.get(o1.genre) == map.get(o2.genre)){
                if(o1.play > o2.play){
                    return -1;
                }
            }
            return 1;
        }
        
    }
    static String temp;
    static int id,cnt;
    static Map <String,Integer> map;
    public static int[] solution(String[] genres, int[] plays) {
        map = new HashMap<>();
        List <Node> list = new ArrayList<>();
        temp = "";
        for(int i=0; i<genres.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
            list.add(new Node(genres[i],plays[i],i));
        }
        
        MyComparator comp = new MyComparator();
        Collections.sort( list,comp);
     
        
        
        temp = list.get(0).genre;
        cnt = 1;
        id = 0;
        int[] answer = new int[200];
        for(int i=0; i<list.size(); i++){
            if(!temp.equals(list.get(i).genre)){
                temp = list.get(i).genre;
                cnt = 1;
                answer[id]=list.get(i).index;
                id++;
                cnt++;
            }else if(cnt < 3){
                answer[id]=list.get(i).index;
                id++;
                cnt++;
               
            }
            
            
        }
        answer = Arrays.copyOfRange(answer,0,id);
       
        return answer;
    }
    
}
