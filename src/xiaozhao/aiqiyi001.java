package xiaozhao;

import java.util.*;
import java.util.Map.Entry;

public class aiqiyi001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int n = Integer.valueOf(line.split(" ")[0]);
		int m = Integer.valueOf(line.split(" ")[1]);
		int p = Integer.valueOf(line.split(" ")[2]);
		int[] nums = new int[n];
		line = in.nextLine();
		String[] strings = line.split(" ");
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0 ; i < n ; i++){
			map.put(i+1, Integer.valueOf(strings[i]));
		}
		for (int i = 0; i < m ;i ++){
			line = in.nextLine();
//			System.out.println(line.split(" ")[0].charAt(0));
//			System.out.println(Integer.valueOf(line.split(" ")[1]));
			if(line.split(" ")[0].charAt(0) == 'A'){
//				nums[Integer.valueOf(line.split(" ")[1])] -=1;
				map.put(Integer.valueOf(line.split(" ")[1]), map.get(Integer.valueOf(line.split(" ")[1]))+1);
			}
			else{
				if(line.split(" ")[0].charAt(0) == 'B'){
//					nums[Integer.valueOf(line.split(" ")[1])] +=1;
					map.put(Integer.valueOf(line.split(" ")[1]), map.get(Integer.valueOf(line.split(" ")[1]))-1);
				}
				else{
					continue;
				}
			} 
		}
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		int count = 0;
		for(Entry<Integer, Integer> t:list){
			count ++;
			if (t.getKey()== p){System.out.println(count);}
//			System.out.println(t.getKey()+":"+t.getValue());
		}

	}
}
