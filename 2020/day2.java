import java.util.*;
public class day2{
	static List<String> input = new ArrayList<>();
	public static void main(String [] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String s = scan.nextLine();
			input.add(s);
		}
		part1();
		part2();

	}
	public static void part1(){
		int count = 0;
		for(String str: input){
			String [] arr = str.split(" ");
			String bounds = arr[0];
			int low = Integer.parseInt(bounds.split("-")[0]);
			int high = Integer.parseInt(bounds.split("-")[1]);
			char letter = arr[1].charAt(0);
			String password = arr[2];
			int [] letters = new int[26];
			for(char c: password.toCharArray()){
				letters[c-'a']++;
			}
			if(letters[letter-'a'] >= low && letters[letter-'a'] <= high )count++;
		}
		System.out.println(count);
	}
	public static void part2(){
		int count = 0;
		for(String str: input){
			String [] arr = str.split(" ");
			String bounds = arr[0];
			int low = Integer.parseInt(bounds.split("-")[0]);
			int high = Integer.parseInt(bounds.split("-")[1]);
			char letter = arr[1].charAt(0);
			String password = arr[2];
			int charCount = 0;
			if(password.charAt(low - 1) == letter){
				charCount++;
			}
			if(password.charAt(high - 1) == letter){
				charCount++;
			}
			if(charCount == 1)count++;
		}
		System.out.println(count);
	}
}