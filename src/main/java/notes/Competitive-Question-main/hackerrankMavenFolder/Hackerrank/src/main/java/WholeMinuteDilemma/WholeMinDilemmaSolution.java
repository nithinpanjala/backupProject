package WholeMinuteDilemma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WholeMinDilemmaSolution {
	 public static long playlist(List<Integer> songs) {
		 	int time = 60;
		 	long count =0;
		 	Map<Integer,Integer> songMap = new HashMap<Integer,Integer>();
		 	for(int i=0;i<songs.size();i++){
		 		int remainder = songs.get(i)%time;
		 		int data = time-remainder == time?0:time-remainder;
		 		if(songMap.containsKey(data)){
		 			count+= songMap.get(data);
		 		}
		 		if(songMap.containsKey(remainder)){
		 			songMap.put(remainder,songMap.get(remainder)+1);
		 		}else {
					 songMap.put(remainder,1);
		 		}

		 	  }
		 	return count ;
		 	}
	 
/*--------------------------Main Method--------------------------- */
	 
	 public static class SolutionMain {
			public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);

				int n = scanner.nextInt();

				List<Integer> arr = new ArrayList<Integer>();

				for (int i = 0; i < n; i++) {
					int listele = scanner.nextInt();
					arr.add(listele);
				}

				long result = playlist(arr);

				System.out.println(result);

				scanner.close();
			}
			
			
		}

}
