import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] resultArr = new int[10]; 
		
		for (int i=0; i<10; i++) {
			int input = sc.nextInt();
			resultArr[i] = input % 42;
		}
		
		int[] countArr = new int[42];
		
		for (int num:resultArr) {
			countArr[num]++;
		}
		
		// countArr에서 0이 아닌 요소 개수 찾기
		int res = 0;
		for (int i=0; i<42; i++) {
			if (countArr[i] != 0) {
				res++;
			}
		}
		
		System.out.println(res);
	}
}