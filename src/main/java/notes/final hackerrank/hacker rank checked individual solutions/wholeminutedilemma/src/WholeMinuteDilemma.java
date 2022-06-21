import java.util.Arrays;
import java.util.Scanner;

public class WholeMinuteDilemma {
	public static int playlist(int songs[]) {
		int numberOfPairs = 0 ;
		Arrays.sort(songs, 0, songs.length);

		for (int i = 0; i < songs.length; i++) {
			for (int j = i + 1; j < songs.length; j++) {

				if (( songs[i] + songs[j]) %60 == 0 ) {
					numberOfPairs +=1;
				}
			}
		}

		return numberOfPairs;
	}
	
	
	public static void main(String[] args) {
		int numberOfPairs = 0 ;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the array size");
		int arrSize = scanner.nextInt();
		int[] songs = new int[arrSize];
		System.out.println("Enter the array elements");
		for (int i = 0; i < arrSize; i++) {
			int a = scanner.nextInt();
			songs[i] = a;

		}
		scanner.close();
		System.out.println(playlist(songs));
	}
}