import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 응시자 수
		int k = sc.nextInt(); // 상 받는 사람 수
		
		// 응시자 점수 리스트
		List<Integer> scoreList = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			scoreList.add(sc.nextInt());	
		}
		
		scoreList.sort(Comparator.reverseOrder());
		
		System.out.println(scoreList.get(k-1));
	}

}