import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt(); // 부르는 횟수
		
		// 스택
		Stack<Integer> moneys = new Stack<>();
		
		for (int i=0;i<k;i++) {
			int money = sc.nextInt();
			if (money != 0) {
				moneys.push(money);
			} else { // 돈을 잘못 불렀을 경우
				moneys.pop();
			}
		}
		
		int sum = 0;

		for (int i=0;i<moneys.size();i++) {
			sum += moneys.get(i);
		}
		
		System.out.println(sum);
	}
}