import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 일단 남 / 여 배열 분리 후
		// 각 배열에서 학년 별 인원 수 체크 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 방 최대 인원 수
		
		int[] wArr = new int[6]; 
		int[] mArr = new int[6]; // 학년 별 몇명인지 count할 배열 생성 
		
		for (int i=0;i<N;i++) {
			int sex = sc.nextInt(); // 성별
			int grade = sc.nextInt(); // 학년
			
			if (sex == 0) { // 여학생
				wArr[grade-1]++;
			} else { // 남학생
				mArr[grade-1]++;
			}
		}
		
		// 필요한 방 개수 카운트
		int count = 0;

		for (int i=0; i<6; i++) {
			count += Math.ceil((double)wArr[i]/K);
			count += Math.ceil((double)mArr[i]/K);
		}

		System.out.println(count);

	}
}