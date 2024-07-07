import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 3 <= N <= 50
		int M = sc.nextInt(); // M <= 50
		int L = sc.nextInt(); // L <= N-1

		// 1번이 M에 가장 먼저 도착함
		// => 1번의 cnt 올라가는 시점 : 공을 N과 L의 최대공약수로 N을 나눈 수 만큼 던졌을 때

		// 최대공약수 구하기
		int max = 0;

		for (int i = 1; i <= N && i <= L; i++) {
			if (N % i == 0 && L % i == 0) {
				max = i;
			}
		}

		int res = 0;

		if (M == 1) { // 게임 끝나는 기준이 1이면 1번이 받자마자 끝남
			res = 0;
		} else {
			res = (M - 1) * (N / max);
		}

		System.out.println(res);

	}
}